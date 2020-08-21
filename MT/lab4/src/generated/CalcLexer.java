package generated;

import atom.Atom;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcLexer {
    private String input;
    private Pattern skip;
    private Map<String, Pattern> tokens;
    Atom.Token curToken;

    CalcLexer(String input) {
        this.input = input;
        this.skip = Pattern.compile(" ");
        this.tokens = new LinkedHashMap<>();
        tokens.put("PLUS", Pattern.compile("\\+"));
        tokens.put("POW", Pattern.compile("\\*{2}"));
        tokens.put("MINUS", Pattern.compile("-"));
        tokens.put("MUL", Pattern.compile("\\*"));
        tokens.put("DIV", Pattern.compile("/"));
        tokens.put("LB", Pattern.compile("\\("));
        tokens.put("RB", Pattern.compile("\\)"));
        tokens.put("NUM", Pattern.compile("([1-9][0-9]*)|0"));
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