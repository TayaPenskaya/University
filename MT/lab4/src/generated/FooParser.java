package generated;

import java.text.ParseException;

import atom.Atom;

public class FooParser {
    private FooLexer lexer;

    public FooParser(String string) throws ParseException {
        this.lexer = new FooLexer(string);
    }

    public ParseTree parse() throws ParseException {
        lexer.nextToken();
        return start();
    }

    private ParseTree start() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "WORD":
                ParseTree t = type();
                ParseTree n = name();
                ParseTree lbr = new ParseTree("(");
                lexer.nextToken();
                ParseTree a = args();
                ParseTree rbr = new ParseTree(")");
                lexer.nextToken();
                ParseTree c = const_();
                ParseTree semi = new ParseTree(";"); res = new ParseTree("Function", t, n, lbr, a, rbr, c, semi);
                lexer.nextToken();
                break;
            default:
                throw new ParseException("Illegal token in start()", 1);
        }
        return res;
    }

    private ParseTree args() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "WORD":
            case "CONST":
                ParseTree a = arg();
                ParseTree a_ = arg_();
                res = new ParseTree("Args", a, a_);
                break;
            case "RBR":
                res = new ParseTree("Args");
                break;
            default:
                throw new ParseException("Illegal token in args()", 1);
        }
        return res;
    }

    private ParseTree arg() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "WORD":
            case "CONST":
                ParseTree c = const_();
                ParseTree t = type();
                ParseTree s = star();
                ParseTree n = name();
                res = new ParseTree("Arg", c, t, s, n);
                break;
            default:
                throw new ParseException("Illegal token in arg()", 1);
        }
        return res;
    }

    private ParseTree arg_() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "COMMA":
                ParseTree comma = new ParseTree(",");
                lexer.nextToken();
                ParseTree c = const_();
                ParseTree t = type();
                ParseTree s = star();
                ParseTree n = name();
                ParseTree a_ = arg_();
                res = new ParseTree("Arg_", comma, c, t, s, n, a_);
                break;
            case "RBR":
                res = new ParseTree("Arg_");
                break;
            default:
                throw new ParseException("Illegal token in arg_()", 1);
        }
        return res;
    }

    private ParseTree const_() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "CONST":
                res = new ParseTree("Const", new ParseTree("const"));
                lexer.nextToken();
                break;
            case "WORD":
            case "SEMI":
                res = new ParseTree("Const");
                break;
            default:
                throw new ParseException("Illegal token in const_()", 1);
        }
        return res;
    }

    private ParseTree star() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "STAR":
                ParseTree starT = new ParseTree("*");
                lexer.nextToken();
                ParseTree s = star();
                res = new ParseTree("Star", starT, s);
                break;
            case "WORD":
                res = new ParseTree("Star");
                break;
            default:
                throw new ParseException("Illegal token in star()", 1);
        }
        return res;
    }

    private ParseTree type() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "WORD":
                Atom.Token w = lexer.curToken;
                res = new ParseTree("Name", new ParseTree(w.getFilling()));
                lexer.nextToken();
                break;
            default:
                throw new ParseException("Illegal token in type()", 1);
        }
        return res;
    }

    private ParseTree name() throws ParseException {
        ParseTree res;
        switch (lexer.curToken.getName()) {
            case "WORD":
                Atom.Token w = lexer.curToken;
                res = new ParseTree("Name", new ParseTree(w.getFilling()));
                lexer.nextToken();
                break;
            default:
                throw new ParseException("Illegal token in name()", 1);
        }
        return res;
    }

}