// Generated from edu/temple/cis/c4324/micro/Micro.g4 by ANTLR 4.5.1

package edu.temple.cis.c4324.micro;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MicroParser}.
 */
public interface MicroListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MicroParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MicroParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(MicroParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(MicroParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link MicroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRead(MicroParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link MicroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRead(MicroParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code write}
	 * labeled alternative in {@link MicroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWrite(MicroParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code write}
	 * labeled alternative in {@link MicroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWrite(MicroParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MicroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MicroParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MicroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MicroParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#read_statement}.
	 * @param ctx the parse tree
	 */
	void enterRead_statement(MicroParser.Read_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#read_statement}.
	 * @param ctx the parse tree
	 */
	void exitRead_statement(MicroParser.Read_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(MicroParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(MicroParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#write_statement}.
	 * @param ctx the parse tree
	 */
	void enterWrite_statement(MicroParser.Write_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#write_statement}.
	 * @param ctx the parse tree
	 */
	void exitWrite_statement(MicroParser.Write_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(MicroParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(MicroParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(MicroParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(MicroParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(MicroParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(MicroParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerop}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowerop(MicroParser.PoweropContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerop}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowerop(MicroParser.PoweropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryop}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryop(MicroParser.UnaryopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryop}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryop(MicroParser.UnaryopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(MicroParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(MicroParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(MicroParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(MicroParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithop}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithop(MicroParser.ArithopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithop}
	 * labeled alternative in {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithop(MicroParser.ArithopContext ctx);
}