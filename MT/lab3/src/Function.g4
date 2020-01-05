grammar Function;

/*
 * Parser Rules
 */

name                    :   NAME;

code                    :   statement* EOF;
statement               :   function_header L_BRACE body R_BRACE;

function_header         :   type_foo NAME L_PAR args R_PAR;
type_foo                :   TYPE | VOID;

arg                     :   TYPE name ;
args                    :   (arg (COMMA arg)*)?;
body                    :   (declaration | assignment | prefix | ifElse | whileBody | forBody | read | write | return_statement | foo_in_foo)*;


declaration             :   TYPE name (EQUAL expression)? (COMMA name (EQUAL expression)?)* SEMI;
assignment              :   name EQUAL expression SEMI;
prefix                  :   prefix_expression SEMI;
return_statement        :   RETURN expression SEMI;
read                    :   CIN (IN name)+ SEMI;
write                   :   COUT (OUT expression)+ (OUT ENDL)? SEMI;
foo_in_foo              :   NAME L_PAR args R_PAR SEMI;


ifElse                  :   ifBody (ELSE (ifBody * | L_BRACE body R_BRACE))?;
ifBody                  :   IF in_par L_BRACE body R_BRACE;
whileBody               :   WHILE in_par L_BRACE body R_BRACE;
forBody                 :   FOR L_PAR declaration name eq_op expression SEMI (bin_expression | prefix_expression) R_PAR L_BRACE body R_BRACE;
in_par                  :   L_PAR (expression eq_op expression | expression) R_PAR;


expression              :   bin_or_eq_expression | prefix_expression | TRUE | FALSE | NUMBER | string | name;
bin_or_eq_expression    :   var ((bin_op | eq_op) var)+;
bin_expression          :   var (bin_op var)+;
prefix_expression       :   prefix_op name;

bin_op                  :   PLUS | MINUS | MULT | DIV | MOD;
eq_op                   :   EQ | LESS | LESS_EQ | GREATER | GR_EQ;
prefix_op               :   INC | DEC;
var                     :   TRUE | FALSE | NUMBER | string | name;
string                  :   CHARS;


/*
 * Lexer Rules
 */

fragment INT            :   'int';
fragment BOOL           :   'bool';
fragment STRING         :   'std::string';
TYPE                    :   INT | BOOL | STRING;
VOID                    :   'void';
TRUE                    :   'true';
FALSE                   :   'false';
RETURN                  :   'return';
IF                      :   'if';
ELSE                    :   'else';
WHILE                   :   'while';
FOR                     :   'for';
CIN                     :   'std::cin';
COUT                    :   'std::cout';
ENDL                    :   'std::endl';

L_PAR                   :   '(';
R_PAR                   :   ')';
L_BRACE                 :   '{';
R_BRACE                 :   '}';
L_BRACKET               :   '[';
R_BRACKET               :   ']';

IN                      :   '>>';
OUT                     :   '<<';

EQUAL                   :   '=';
LESS                    :   '<';
LESS_EQ                 :   '<=';
GREATER                 :   '>';
GR_EQ                   :   '>=';
EQ                      :   '==';

SEMI                    :   ';';
COMMA                   :   ',';
INC                     :   '++';
DEC                     :   '--';
PLUS                    :   '+';
MINUS                   :   '-';
MULT                    :   '*';
DIV                     :   '/';
MOD                     :   '%';

QUOTE                   :   '"';

fragment DIGIT          :   [0-9];
fragment LETTER         :   [a-zA-Z];
NUMBER                  :   DIGIT+;
CHARS                   :   '"' .*? '"';
NAME                    :   LETTER (LETTER | DIGIT | '_')*;
WS                      :   [ \n\r\t]+ -> skip;