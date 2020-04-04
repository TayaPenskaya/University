package generated;

import java.text.ParseException;

import atom.Atom;

public class CalcParser {
    private CalcLexer lexer;

    public CalcParser(String string) throws ParseException {
        this.lexer = new CalcLexer(string);
    }

    public int parse() throws ParseException {
        lexer.nextToken();
        return start();
    }

    private int start() throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "LB":
            case "NUM":
            case "MINUS":
                int t1 = t();
                int e_1 = e_(t1);
                res = e_1;
                break;
            default:
                throw new ParseException("Illegal token in start()", 1);
        }
        return res;
    }

    private int e_(int acc) throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "PLUS":
                lexer.nextToken();
                int t1 = t();
                int propAcc = acc + t1;
                int e_1 = e_(propAcc);
                res = e_1;
                break;
            case "MINUS":
                lexer.nextToken();
                int t2 = t();
                int propAcc2 = acc - t2;
                int e_2 = e_(propAcc2);
                res = e_2;
                break;
            case "RB":
            case "END":
                res = acc;
                break;
            default:
                throw new ParseException("Illegal token in e_()", 1);
        }
        return res;
    }

    private int t() throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "LB":
            case "NUM":
            case "MINUS":
                int s1 = s();
                int t_1 = t_(s1);
                res = t_1;
                break;
            default:
                throw new ParseException("Illegal token in t()", 1);
        }
        return res;
    }

    private int t_(int acc) throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "MUL":
                lexer.nextToken();
                int s1 = s();
                int propAcc = acc * s1;
                int t_1 = t_(propAcc);
                res = t_1;
                break;
            case "DIV":
                lexer.nextToken();
                int s2 = s();
                int propAcc2 = acc / s2;
                int t_2 = t_(propAcc2);
                res = t_2;
                break;
            case "RB":
            case "END":
            case "PLUS":
            case "MINUS":
                res = acc;
                break;
            default:
                throw new ParseException("Illegal token in t_()", 1);
        }
        return res;
    }

    private int s() throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "LB":
            case "NUM":
            case "MINUS":
                int f1 = f();
                int s_1 = s_(f1);
                res = s_1;
                break;
            default:
                throw new ParseException("Illegal token in s()", 1);
        }
        return res;
    }

    private int s_(int acc) throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "POW":
                lexer.nextToken();
                int f1 = f();
                int s_1 = s_(f1);
                res = (int)Math.pow((double)acc, (double)s_1);
                break;
            case "DIV":
            case "RB":
            case "MUL":
            case "END":
            case "PLUS":
            case "MINUS":
                res = acc;
                break;
            default:
                throw new ParseException("Illegal token in s_()", 1);
        }
        return res;
    }

    private int f() throws ParseException {
        int res;
        switch (lexer.curToken.getName()) {
            case "LB":
                lexer.nextToken();
                int e1 = start();
                res = e1;
                lexer.nextToken();
                break;
            case "NUM":
                Atom.Token num = lexer.curToken;
                res = Integer.parseInt(num.getFilling());
                lexer.nextToken();
                break;
            case "MINUS":
                lexer.nextToken();
                int f1 = f();
                res = -1 * f1;
                break;
            default:
                throw new ParseException("Illegal token in f()", 1);
        }
        return res;
    }

}