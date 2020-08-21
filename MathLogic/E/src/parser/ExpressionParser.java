package parser;

import expression.*;

import java.util.ArrayList;
import java.util.List;


public class ExpressionParser {
    private String text;
    private Token token;
    private int ch;
    private int index = 0;
    private String variable;
    private boolean classic;

    public ExpressionParser(boolean classic) {
        this.classic = classic;
    }

    private void skipWhiteSpaces() {
        while (Character.isWhitespace(ch)) {
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


    private void nextToken() {

        nextChar();

        skipWhiteSpaces();

        if (ch == -1) {
            token = Token.EOL;
            return;
        }

        switch (ch) {
            case '&':
                token = Token.CON;
                break;
            case '|':
                token = Token.DIS;
                break;
            case '-':
                nextChar();
                token = Token.IMPL;
                break;
            case '!':
                token = Token.NEG;
                break;
            case '(':
                token = Token.LBR;
                break;
            case ')':
                token = Token.RBR;
                break;
            case '@':
                token = Token.ANY;
                ;
                break;
            case '?':
                token = Token.EXISTS;
                break;
            case ',':
                token = Token.COMMA;
                break;
            case '=':
                token = Token.EQ;
                break;
            case '+':
                token = Token.ADD;
                break;
            case '*':
                token = Token.MUL;
                break;
            case '0':
                token = Token.ZERO;
                break;
            case '.':
                token = Token.DOT;
                break;
            case '\'':
                token = Token.NEXT;
                break;
            default:
                StringBuilder sb = new StringBuilder();
                if (Character.isLowerCase(ch)) {
                    sb.append((char) ch);
                    nextChar();
                    while (index - 1 < text.length() && (Character.isLowerCase(ch) || Character.isDigit(ch))) {
                        sb.append((char) ch);
                        nextChar();
                    }
                    token = Token.VAR;
                } else if (Character.isUpperCase(ch)) {
                    sb.append((char) ch);
                    nextChar();
                    while (index - 1 < text.length() && (Character.isUpperCase(ch) || Character.isDigit(ch))) {
                        sb.append((char) ch);
                        nextChar();
                    }
                    token = Token.UP;
                }
                variable = sb.toString();
                --index;
                break;
        }
    }

    public Expression parse(String text) throws ParseException {
        index = 0;
        this.text = text;
        nextToken();
        return parseImpl();
    }

    private Expression parseImpl() throws ParseException {
        Expression res = parseDis();
        while (true) {
            switch (token) {
                case IMPL:
                    nextToken();
                    res = new Implication(res, parseImpl());
                    break;
                default:
                    return res;
            }
        }
    }

    private Expression parseDis() throws ParseException {
        Expression res = parseCon();
        while (true) {
            switch (token) {
                case DIS:
                    nextToken();
                    res = new Disjunction(res, parseCon());
                    break;
                default:
                    return res;
            }
        }
    }


    private Expression parseCon() throws ParseException {
        Expression res = parseUnary();
        while (true) {
            switch (token) {
                case CON:
                    nextToken();
                    res = new Conjunction(res, parseUnary());
                    break;
                default:
                    return res;
            }
        }
    }


    private Expression parseUnary() throws ParseException {
        if (classic) {
            Expression res;
            switch (token) {
                case NEG:
                    nextToken();
                    res = new Negation(parseUnary());
                    break;
                case VAR:
                    res = new Variable(variable);
                    nextToken();
                    break;
                case LBR:
                    nextToken();
                    res = parseImpl();
                    if (token != Token.RBR) {
                        throw new ParseException("Unexpected token " + token + " while expecting RBR while parsing classic Unary");
                    }
                    nextToken();
                    break;
                default:
                    throw new ParseException("Unexpected token " + token + " while parsing classic Unary");
            }
            return res;
        }

        Expression res;
        switch (token) {
            case NEG:
                nextToken();
                res = new Negation(parseUnary());
                break;
            case ANY:
                nextToken();
                Variable var;
                switch (token) {
                    case VAR:
                        var = new Variable(variable);
                        break;
                    default:
                        throw new ParseException("Unexpected token " + token + " was found while parsing Variable");
                }
                nextToken();
                if (token != Token.DOT){
                    throw new ParseException("Unexpected token " + token + " was found while parsing Any");
                }
                nextToken();
                res = new Any(var, parseImpl());
                break;
            case EXISTS:
                nextToken();
                Variable var1;
                switch (token) {
                    case VAR:
                        var1 = new Variable(variable);
                        break;
                    default:
                        throw new ParseException("Unexpected token " + token + " was found while parsing Variable");
                }
                nextToken();
                if (token != Token.DOT){
                    throw new ParseException("Unexpected token " + token + " was found while parsing Any");
                }
                nextToken();
                res = new Exists(var1, parseImpl());
                break;
            case LBR:
                if (isTherm()) {
                    res = parsePred();
                    break;
                } else {
                    nextToken();
                    res = parseImpl();
                    if (token != Token.RBR) {
                        throw new ParseException("Unexpected token " + token + " was found while expecting RBR while parsing Unary");
                    }
                    nextToken();
                    break;
                }
            default:
                res = parsePred();
                break;
        }
        return res;
    }

    private boolean isTherm() {
        int ind = index;
        for (int balance = 1; balance != 0; ++ind) {
            if (text.charAt(ind) == '(')
                balance++;
            if (text.charAt(ind) == ')')
                balance--;
            if (text.charAt(ind) == '-' && text.charAt(ind + 1) == '>' || text.charAt(ind) == '|'
                    || text.charAt(ind) == '&' || text.charAt(ind) == '@' || text.charAt(ind) == '?'
                    || text.charAt(ind) == '!' || text.charAt(ind) == '=' || Character.isUpperCase(text.charAt(ind))) {
                return false;
            }
        }
        return true;
    }

    private Variable parseVar() throws ParseException {
        Variable res;
        switch (token) {
            case VAR:
                res = new Variable(variable);
                break;
            default:
                throw new ParseException("Unexpected token " + token + " was found while parsing Variable");
        }
        nextToken();
        return res;
    }

    private Expression parsePred() throws ParseException {
        if (token == Token.UP) {
            String name = variable;
            nextToken();
            List<Expression> therms = new ArrayList<>();
            if (token == Token.LBR) {
                nextToken();
                Expression therm = parseTherm();
                therms.add(therm);
                while (token == Token.COMMA) {
                    nextToken();
                    therm = parseTherm();
                    therms.add(therm);
                }
                if (token != Token.RBR) {
                    throw new ParseException("Unexpected token " + token + " was found while expecting RBR while parsing Predicate");
                }
                nextToken();
            }
            return new Predicate(new Variable(name), therms);
        } else {
            Expression left = parseTherm();
            if (token != Token.EQ) {
                throw new ParseException("Unexpected token " + token + " was found while parsing Predicate");
            }
            nextToken();
            Expression right = parseTherm();
            return new Eq(left, right);
        }
    }

    private Expression parseTherm() throws ParseException {
        Expression res = parseAdd();
        while (true) {
            switch (token) {
                case ADD:
                    nextToken();
                    res = new Add(res, parseAdd());
                    break;
                default:
                    return res;
            }
        }
    }

    private Expression parseAdd() throws ParseException {
        Expression res = parseMul();
        while (true) {
            switch (token) {
                case MUL:
                    nextToken();
                    res = new Mul(res, parseMul());
                    break;
                default:
                    return res;
            }
        }
    }

    private Expression parseMul() throws ParseException {
        Expression res;
        switch (token) {
            case VAR:
                String name = variable;
                nextToken();
                List<Expression> therms = new ArrayList<>();
                if (token != Token.LBR) {
                    res = new Variable(variable);
                } else {
                    nextToken();
                    Expression therm = parseTherm();
                    therms.add(therm);
                    while (token == Token.COMMA) {
                        nextToken();
                        therm = parseTherm();
                        therms.add(therm);
                    }
                    if (token != Token.RBR) {
                        throw new ParseException("Unexpected token" + token + " was found while expecting RBR while parsing Multiply");
                    }
                    nextToken();
                    res = new Function(new Variable(name), therms);
                }
                break;
            case ZERO:
                nextToken();
                res = new Zero();
                break;
            case LBR:
                nextToken();
                res = parseTherm();
                if (token != Token.RBR) {
                    throw new ParseException("Unexpected token" + token + " was found while expecting RBR while parsing Multiply");
                }
                nextToken();
                break;
            default:
                throw new ParseException("Unexpected token" + token + " was found while parsing Multiply");
        }
        while (token == Token.NEXT) {
            nextToken();
            res = new Next(res);
        }
        return res;
    }


}
