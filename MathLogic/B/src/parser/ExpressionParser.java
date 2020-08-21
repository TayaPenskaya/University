package parser;

import expression.Conjunction;
import expression.Disjunction;
import expression.Expression;
import expression.Implication;
import expression.Negation;
import expression.Variable;


//ALL -- HANDLE EOL PROOF
//HANDLE -- HYPS TURN EXPR
//HYPS -- Eps | EXPR CONTHYPS
//CONTHYPS -- Eps | COMMA EXPR CONTHYPS
//
public class ExpressionParser {
    private String text;
    private Token token;
    private int ch;
    private int index = 0;
    private String variable;

    private void skipWhiteSpaces(){
        while (Character.isWhitespace(ch)){
            nextChar();
        }
    }


    private void nextChar() {
        if (index < text.length()) {
            ch = text.charAt(index);
            ++index;
        } else {
            ch = -1;
        }
    }

    private void parseVariable() {
        StringBuilder sb = new StringBuilder();
        if (Character.isLetter(ch)) {
            sb.append((char) ch);
            nextChar();
            while (index - 1 < text.length() && (Character.isLetter(ch) || Character.isDigit(ch) || ch == '\'')) {
                sb.append((char) ch);
                nextChar();
            }
        }
        variable = sb.toString();

    }

    private void nextToken() {

        skipWhiteSpaces();
        if (ch == -1) {
            token = Token.EOL;
            return;
        }

        if (Character.isLetter(ch)) {
            parseVariable();
            token = Token.VAR;
            return;
        }

        switch (ch) {
            case '&':
                token = Token.CON;
                nextChar();
                break;
            case '|':
                token = Token.DIS;
                nextChar();
                break;
            case '-':
                nextChar();
                token = Token.IMPL;
                nextChar();
                break;
            case '!':
                token = Token.NEG;
                nextChar();
                break;
            case '(':
                token = Token.LBR;
                nextChar();
                break;
            case ')':
                token = Token.RBR;
                nextChar();
                break;
        }
    }

    public Expression parse(String text) throws ParseException {
        index = 0;
        this.text = text;
        nextChar();
        nextToken();
        return parseImpl();
    }

    private Expression parseImpl() throws ParseException {
        Expression res;
        switch (token) {
            case LBR:
            case VAR:
            case NEG:
                res = ContImpl(parseDis());
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing Impl");
        }
        return res;
    }

    private Expression ContImpl(Expression left) throws ParseException {
        Expression res;
        switch (token) {
            case RBR:
            case EOL:
                res = left;
                break;
            case IMPL:
                nextToken();
                res = new Implication(left, parseImpl());
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing ContImpl");
        }
        return res;
    }


    private Expression parseDis() throws ParseException {
        Expression res;
        switch (token) {
            case LBR:
            case VAR:
            case NEG:
                res = ContDis(parseCon());
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing ContDis");
        }
        return res;
    }

    private Expression ContDis(Expression left) throws ParseException {
        Expression res;
        switch (token) {
            case RBR:
            case IMPL:
            case EOL:
                res = left;
                break;
            case DIS:
                nextToken();
                res = ContDis(new Disjunction(left, parseCon()));
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing ContDis");
        }
        return res;
    }

    private Expression parseCon() throws ParseException {
        Expression res;
        switch (token) {
            case LBR:
            case VAR:
            case NEG:
                res = ContCon(parseUnary());
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing Con");
        }
        return res;
    }

    private Expression ContCon(Expression left) throws ParseException {
        Expression res;
        switch (token) {
            case RBR:
            case DIS:
            case IMPL:
            case EOL:
                res = left;
                break;
            case CON:
                nextToken();
                res = ContCon(new Conjunction(left, parseUnary()));
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing ContCon");
        }
        return res;
    }

    private Expression parseUnary() throws ParseException {
        Expression res;
        switch (token) {
            case LBR:
                nextToken();
                res = parseImpl();
                if (token != Token.RBR) {
                    throw new ParseException("There was supposed to be right bracket!");
                }
                nextToken();
                break;
            case NEG:
                nextToken();
                res = new Negation(parseUnary());
                break;
            case VAR:
                res = new Variable(variable);
                nextToken();
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing Unary");
        }
        return res;
    }
}
