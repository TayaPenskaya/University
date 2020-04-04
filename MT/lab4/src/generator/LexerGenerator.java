package generator;

import grammar.Grammar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexerGenerator {

    private final Path out;
    private final String name;
    private final Grammar grammar;

    private final String Q = "\"";

    public LexerGenerator(Path out, String name, Grammar grammar){
        this.out = out;
        this.name = name;
        this.grammar = grammar;
    }

    public void createLexer() throws IOException {
        File file = new File(out + "/" + name + "Lexer.java");
        FileWriter writer = new FileWriter(file);

        List<Grammar.LexerRule> lexerRules = grammar.getLexerRules();

        StringGenerator gen = new StringGenerator(new StringBuilder());

        gen.add(0, "package generated;", 2);

        gen.addManyOnSameLevel(0,
                new ArrayList<>(Arrays.asList("import atom.Atom;", "import java.text.ParseException;",
                        "import java.util.LinkedHashMap;", "import java.util.Map;",
                        "import java.util.regex.Matcher;", "import java.util.regex.Pattern;\n")));

        gen.add(0, "public class " + name + "Lexer {", 1);
        gen.addManyOnSameLevel(1,
                new ArrayList<>(Arrays.asList("private String input;", "private Pattern skip;",
                        "private Map<String, Pattern> tokens;", "Atom.Token curToken;\n")));

        gen.add(1, name + "Lexer(String input) {", 1);
        gen.addManyOnSameLevel(2,
                new ArrayList<>(Arrays.asList("this.input = input;", "this.skip = Pattern.compile(\" \");",
                        "this.tokens = new LinkedHashMap<>();")));

        for (Grammar.LexerRule rule : lexerRules){
            String tokenName = rule.getName();
            String regex = rule.getRegex();
            gen.add(2, "tokens.put(" + Q + tokenName + Q + ", Pattern.compile(" + regex + "));", 1);
        }

        gen.add(1, "}", 2);

        gen.add(1, "void nextToken() throws ParseException {", 1);
        gen.add(2, "int length = input.length();", 2);
        gen.addManyOnSameLevel(2, new ArrayList<>(Arrays.asList("Matcher matcher = skip.matcher(input);",
                "while(matcher.lookingAt()) {")));
        gen.addManyOnSameLevel(3, new ArrayList<>(Arrays.asList("input = input.substring(matcher.end());",
                "matcher.reset(input);")));
        gen.add(2, "}", 2);

        gen.add(2, "for (String token : tokens.keySet()) {", 1);
        gen.addManyOnSameLevel(3, new ArrayList<>(Arrays.asList("Pattern pattern = tokens.get(token);",
                "matcher = pattern.matcher(input);", "if (matcher.lookingAt()) {")));
        gen.addManyOnSameLevel(4, new ArrayList<>(Arrays.asList("curToken = new Atom.Token(token, input.substring(0, matcher.end()));",
                "input = input.substring(matcher.end());", "matcher.reset(input);", "return;")));
        gen.add(3, "}", 1);
        gen.add(2, "}", 2);

        gen.add(2, "if (input.length() == 0) {",1);
        gen.add(3, "curToken = new Atom.Token(\"END\");", 1);
        gen.add(2, "} else {", 1);
        gen.add(3, "throw new ParseException(\"Lexer error\", length - input.length());", 1);
        gen.add(2, "}", 1);

        gen.add(1, "}", 1);
        gen.add(0, "}", 0);

//        System.out.println(gen.getSb().toString());

        writer.write(gen.getSb().toString());
        writer.close();
    }
}
