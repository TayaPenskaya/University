package generated;

import atom.Atom;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FooLexer {
    private String input;
    private Pattern skip;
    private Map<String, Pattern> tokens;
    Atom.Token curToken;

    FooLexer(String input) {
        this.input = input;
        this.skip = Pattern.compile(" ");
        this.tokens = new LinkedHashMap<>();
        tokens.put("CONST", Pattern.compile("const"));
        tokens.put("LBR", Pattern.compile("\\("));
        tokens.put("RBR", Pattern.compile("\\)"));
        tokens.put("COMMA", Pattern.compile(","));
        tokens.put("SEMI", Pattern.compile(";"));
        tokens.put("STAR", Pattern.compile("\\*"));
        tokens.put("WORD", Pattern.compile("[A-Za-z]+"));
    }

    void nextToken() throws ParseException {
        int length = input.length();

        Matcher matcher = skip.matcher(input);
        while(matcher.lookingAt()) {
            input = input.substring(matcher.end());
            matcher.reset(input);
        }

        for (String token : tokens.keySet()) {
            Pattern pattern = tokens.get(token);
            matcher = pattern.matcher(input);
            if (matcher.lookingAt()) {
                curToken = new Atom.Token(token, input.substring(0, matcher.end()));
                input = input.substring(matcher.end());
                matcher.reset(input);
                return;
            }
        }

        if (input.length() == 0) {
            curToken = new Atom.Token("END");
        } else {
            throw new ParseException("Lexer error", length - input.length());
        }
    }
}