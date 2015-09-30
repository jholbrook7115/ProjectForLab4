package edu.temple.cis.c4324.microcompilerv1;

import edu.temple.cis.c4324.codegen.CodeGenerator;
import edu.temple.cis.c4324.codegen.InstructionList;
import edu.temple.cis.c4324.micro.MicroBaseVisitor;
import edu.temple.cis.c4324.micro.MicroParser;
import edu.temple.cis.c4324.micro.MicroParser.ArithopContext;
import edu.temple.cis.c4324.micro.MicroParser.Assignment_statementContext;
import edu.temple.cis.c4324.micro.MicroParser.IdContext;
import edu.temple.cis.c4324.micro.MicroParser.IntContext;
import edu.temple.cis.c4324.micro.MicroParser.PoweropContext;
import edu.temple.cis.c4324.micro.MicroParser.ProgramContext;
import edu.temple.cis.c4324.micro.MicroParser.Read_statementContext;
import edu.temple.cis.c4324.micro.MicroParser.Statement_listContext;
import edu.temple.cis.c4324.micro.MicroParser.UnaryopContext;
import edu.temple.cis.c4324.micro.MicroParser.Write_statementContext;
import org.apache.bcel.generic.MethodGen;

public class CompileVisitor extends MicroBaseVisitor<InstructionList> {

    private final CodeGenerator cg;
    private final String sourceFileName;
    private boolean inDefined;

    public CompileVisitor(String sourceFileName, CodeGenerator cg) {
        this.cg = cg;
        this.sourceFileName = sourceFileName;
        inDefined = false;
    }

    @Override
    public InstructionList visitProgram(ProgramContext ctx) {
        cg.beginClass(sourceFileName, ctx.ID().getText());
        MethodGen mg = cg.beginMain();
        InstructionList il = cg.newInstructionList();
        il.append(visit(ctx.statement_list()));
        il.addInstruction("return");
        mg.getInstructionList().append(il);
        cg.endMethod();
        return null;
    }

    @Override
    public InstructionList visitStatement_list(Statement_listContext ctx) {
        InstructionList il = cg.newInstructionList();
        int numChildren = ctx.getChildCount();
        for (int i = 0; i < numChildren; i++) {
            il.append(visit(ctx.getChild(i)));
        }
        return il;
    }

    @Override
    public InstructionList visitRead_statement(Read_statementContext ctx) {
        InstructionList il = cg.newInstructionList();
        if (!inDefined) {
            cg.addLocalVariable("$in", "java.util.Scanner");
            il.addInstruction("new", "java.util.Scanner");
            il.addInstruction("dup");
            il.addInstruction("getstatic", "java.lang.System.in", "java.io.InputStream");
            il.addInstruction("invokespecial", "java.util.Scanner.<init>", "void", "java.io.InputStream");
            il.addInstruction("astore", "$in");
            inDefined = true;
        }
        ctx.id_list().ID().forEach(id -> {
            cg.addLocalVariable(id.getText(), "int");
            il.addInstruction("aload", "$in");
            il.addInstruction("invokevirtual", "java.util.Scanner.nextInt", "int");
            il.addInstruction("istore", id.getText());
        });
        return il;
    }

    @Override
    public InstructionList visitAssignment_statement(Assignment_statementContext ctx) {
        String target = ctx.ID().getText();
        cg.addLocalVariable(target, "int");
        InstructionList il = cg.newInstructionList();
        il.append(visit(ctx.expr()));
        il.addInstruction("istore", target);
        return il;
    }

    @Override
    public InstructionList visitArithop(ArithopContext ctx) {
        InstructionList il = cg.newInstructionList();
        il.append(visit(ctx.expr(0)));
        il.append(visit(ctx.expr(1)));
        il.addInstruction("op", ctx.op.getText(), "int");
        return il;
    }

    @Override
    public InstructionList visitUnaryop(UnaryopContext ctx) {
        InstructionList il = cg.newInstructionList();
        il.append(visit(ctx.expr()));
        if (ctx.op.getText().equals("~")) {
            il.addInstruction("iconst_m1");
            il.addInstruction("xor", "int");
        } else if (ctx.op.getText().equals("-")) {
            il.addInstruction("neg", "int");
        }
        return il;
    }

    @Override
    public InstructionList visitPowerop(PoweropContext ctx){
        InstructionList il = cg.newInstructionList();
        il.append(visit(ctx.expr(0)));
        il.addInstruction("op", "int", "double");
        il.append(visit(ctx.expr(1)));
        il.addInstruction("cast", "int", "double");

        il.addInstruction("invokestatic", "java/lang/Math.pow", "double", "double", "double");

        il.addInstruction("cast", "double", "int");
        
        return il;
    }
             
    @Override
    public InstructionList visitId(IdContext ctx) {
        InstructionList il = cg.newInstructionList();
        il.addInstruction("iload", ctx.getText());
        return il;
    }
    
    @Override 
    public InstructionList visitInt(IntContext ctx) {
        InstructionList il = cg.newInstructionList();
        il.addInstruction("const", ctx.getText(), "int");
        return il;
    }

    @Override
    public InstructionList visitWrite_statement(Write_statementContext ctx) {
        InstructionList il = cg.newInstructionList();
        ctx.expr_list().expr().forEach(expr -> {
            il.addInstruction("getstatic", "java.lang.System.out", "java.io.PrintStream");
            il.append(visit(expr));
            il.addInstruction("invokevirtual", "java.io.PrintStream.println", "void", "int");
        });
        return il;
    }
    
}
