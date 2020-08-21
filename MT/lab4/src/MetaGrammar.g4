grammar MetaGrammar;

@header {
import grammar.Grammar;
import atom.Atom;
import java.util.*;
}

/*
 * Parser Rules
 */

metaGrammar returns [Grammar grammar]
: grammarName parsRules lexerRules
{$grammar = new Grammar($grammarName.value, $lexerRules.lexRules, $parsRules.rules);};

grammarName returns [String value]
: GRAMMAR name SEMI
{$value = $name.value;};

parsRules returns [List<Grammar.Rule> rules]
@init{
    $rules = new LinkedList<>();
}
: (parsRule {$rules.addAll($parsRule.rule);})+;

parsRule returns [List<Grammar.Rule> rule]
@init{
    $rule = new LinkedList<>();
}
: NONTERMINAL_NAME L_PAR args R_PAR RETURN L_BRACKET arg R_BRACKET COLON atomExpr SEMI
  {
      for (List<Atom> l : $atomExpr.allAtoms) {
          $rule.add(new Grammar.Rule($NONTERMINAL_NAME.text, $args.vars, $arg.var, l));
      }
  }
| NONTERMINAL_NAME RETURN L_BRACKET arg R_BRACKET COLON atomExpr SEMI
{
    for (List<Atom> l : $atomExpr.allAtoms) {
        $rule.add(new Grammar.Rule($NONTERMINAL_NAME.text, Collections.EMPTY_LIST, $arg.var, l));
    }
};

args returns [List<Grammar.Rule.Variable> vars]
@init{
    $vars = new LinkedList<>();
}
: arg {$vars.add($arg.var);} (COMMA arg {$vars.add($arg.var);})*;

arg returns [Grammar.Rule.Variable var] : t=name n=name {$var = new Grammar.Rule.Variable($t.value, $n.value);};

atomExpr returns [List<List<Atom>> allAtoms]
@init{
    $allAtoms = new LinkedList<>();
}
: atoms {$allAtoms.add($atoms.atomsList);} (OR atoms {$allAtoms.add($atoms.atomsList);})*;

atoms returns [List<Atom> atomsList]
@init{
    $atomsList = new LinkedList<>();
}
: (atom {$atomsList.add($atom.atoM);})+;

atom returns [Atom atoM]
: nonterminal {$atoM = $nonterminal.atoM;}
| token {$atoM = $token.atoM;};

nonterminal returns [Atom atoM]
: name EQ NONTERMINAL_NAME L_PAR params R_PAR CODE? {$atoM = new Atom.Nonterminal($NONTERMINAL_NAME.text, $params.vals, $name.value, $CODE.text);}
| name EQ NONTERMINAL_NAME L_PAR R_PAR CODE? {$atoM = new Atom.Nonterminal($NONTERMINAL_NAME.text, Collections.EMPTY_LIST, $name.value, $CODE.text);}
| NONTERMINAL_NAME {$atoM = new Atom.Nonterminal($NONTERMINAL_NAME.text);};

params returns [List<String> vals]
@init{
    $vals = new LinkedList<>();
}
: param {$vals.add($param.value);} (COMMA param {$vals.add($param.value);})*;

param returns [String value]: name {$value = $name.value;};

token returns [Atom atoM]
: name EQ TOKEN_NAME CODE? {$atoM = new Atom.Token($TOKEN_NAME.text, $name.value, $CODE.text);}
| TOKEN_NAME CODE? {$atoM = new Atom.Token($TOKEN_NAME.text, "", $CODE.text);};

lexerRules returns [List<Grammar.LexerRule> lexRules]
@init{
    $lexRules = new LinkedList<>();
}
: (lexerRule {$lexRules.add($lexerRule.lexRule);})+;

lexerRule returns [Grammar.LexerRule lexRule] : TOKEN_NAME COLON tokenFilling SEMI
{$lexRule = new Grammar.LexerRule($TOKEN_NAME.text, $tokenFilling.regex);};

tokenFilling returns [String regex] : REGEX {$regex = $REGEX.text;};

name returns [String value]: NONTERMINAL_NAME {$value = $NONTERMINAL_NAME.text;} | TOKEN_NAME {$value = $TOKEN_NAME.text;}
| NAME {$value = $NAME.text;};

/*
 * Lexer Rules
 */
GRAMMAR                 :   'grammar';
RETURN                  :   'returns';
HEADER                  :   'header';
MEMBERS                 :   'members';
IMPORT                  :   'import';
SKIP_RULE               :   '-> skip';

SOBAKA                  :   '@';
SEMI                    :   ';';
COLON                   :   ':';
COMMA                   :   ',';

REPEAT                  :   QUESTION | ASTERISK | PLUS;

OR                      :   '|';
QUESTION                :   '?';
ASTERISK                :   '*';
PLUS                    :   '+';

EQ                      :   '=';

L_PAR                   :   '(';
R_PAR                   :   ')';
L_BRACE                 :   '{';
R_BRACE                 :   '}';
L_BRACKET               :   '[';
R_BRACKET               :   ']';

fragment DIGIT          :   [0-9];
NUMBER                  :   DIGIT+;

fragment LOWERCASE      :   [a-z];
fragment UPPERCASE      :   [A-Z];

NONTERMINAL_NAME        :   LOWERCASE (LOWERCASE | UPPERCASE | '_')*;
TOKEN_NAME              :   UPPERCASE (UPPERCASE | '_')*;

LETTER                  :   LOWERCASE | UPPERCASE;
NAME                    :   LETTER (LETTER | DIGIT | '_')*;

CODE                    :   L_BRACE .+? R_BRACE;
REGEX                   :   '"'.*?'"' ;
WS                      :   [ \n\r\t]+ -> skip;