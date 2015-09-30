grammar Micro;
@header {
package edu.temple.cis.c4324.micro;
}


program:            'program' ID 'begin' statement_list 'end' ';'
                    ;

statement_list:     statement*
              ;

statement:          read_statement          #read
         |          write_statement         #write
         |          assignment_statement    #assign
         ;

read_statement:     'read' '(' id_list ')' ';'
              ;

id_list:            ID (',' ID)*
       ;

write_statement:    'write' '(' expr_list ')' ';';

expr_list:          expr (',' expr)*
         ;

assignment_statement:   ID ':=' expr ';';



expr :   op=('+'|'-'|'~') expr              #unaryop
     |   <assoc=right> expr '**' expr       #powerop
     |   expr op=('*'|'/'|'%') expr         #arithop
     |   expr op=('+'|'-') expr             #arithop
     |   ID                                 #id
     |   INT                                #int
     |   '(' expr ')'                       #parens
     ;


fragment LETTER:    [a-zA-Z_];
fragment DIGIT:     [0-9];
ID:                 LETTER (LETTER | DIGIT)*;
INT:                DIGIT+;
WS : [ \t\r\n]+ -> skip ;
