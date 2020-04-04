import gen.MetaGrammarLexer;
import gen.MetaGrammarParser;
import generated.Generator;
import generator.LexerGenerator;
import generator.ParserGenerator;
import grammar.Grammar;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("function")))) {
            String expression = bufferedReader.lines().collect(Collectors.joining("\n"));
            MetaGrammarLexer lexer = new MetaGrammarLexer(new ANTLRInputStream(expression));
            MetaGrammarParser parser = new MetaGrammarParser(new CommonTokenStream(lexer));
            Grammar grammar = parser.metaGrammar().grammar;

            LexerGenerator lexerGenerator = new LexerGenerator(Paths.get("/Users/taya/Documents/University/mt/lab4/src/generated"), grammar.getName(), grammar);
            lexerGenerator.createLexer();

            ParserGenerator parserGenerator = new ParserGenerator(Paths.get("/Users/taya/Documents/University/mt/lab4/src/generated"),
                    grammar.getName(), grammar);
            parserGenerator.createParser();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("calc")))) {
            String expression = bufferedReader.lines().collect(Collectors.joining("\n"));
            MetaGrammarLexer lexer = new MetaGrammarLexer(new ANTLRInputStream(expression));
            MetaGrammarParser parser = new MetaGrammarParser(new CommonTokenStream(lexer));
            Grammar grammar = parser.metaGrammar().grammar;

            LexerGenerator lexerGenerator = new LexerGenerator(Paths.get("/Users/taya/Documents/University/mt/lab4/src/generated"), grammar.getName(), grammar);
            lexerGenerator.createLexer();

            ParserGenerator parserGenerator = new ParserGenerator(Paths.get("/Users/taya/Documents/University/mt/lab4/src/generated"),
                    grammar.getName(), grammar);
            parserGenerator.createParser();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        File myFoo = new File("/Users/taya/Documents/University/mt/lab4/src/generated/Generator.java");
//        FileWriter fooWriter = new FileWriter(myFoo, false);
//        fooWriter.write("package generated;\n" +
//                "\n" +
//                "import java.io.BufferedReader;\n" +
//                "import java.io.FileInputStream;\n" +
//                "import java.io.IOException;\n" +
//                "import java.io.InputStreamReader;\n" +
//                "import java.text.ParseException;\n" +
//                "import java.util.List;\n" +
//                "import java.util.stream.Collectors;\n" +
//                "\n" +
//                "public class Generator {\n" +
//                "\n" +
//                "    public void gen(){\n" +
//                "\n" +
//                "        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(\"tests\")))) {\n" +
//                "            List<String> stringList = bufferedReader.lines().collect(Collectors.toList());\n" +
//                "            for (String string : stringList){\n" +
//                "                FooParser parser = new FooParser(string);\n" +
//                "                ParseTree tree = parser.parse();\n" +
//                "                System.out.println(tree.toString());\n" +
//                "            }\n" +
//                "        } catch (IOException | ParseException e) {\n" +
//                "            e.printStackTrace();\n" +
//                "        }\n" +
//                "\n" +
//                "        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(\"testsCalc\")))) {\n" +
//                "            List<String> stringList = bufferedReader.lines().collect(Collectors.toList());\n" +
//                "            for (String string : stringList){\n" +
//                "                CalcParser parser = new CalcParser(string);\n" +
//                "                int tree = parser.parse();\n" +
//                "                System.out.println(tree);\n" +
//                "            }\n" +
//                "        } catch (IOException | ParseException e) {\n" +
//                "            e.printStackTrace();\n" +
//                "        }\n" +
//                "\n" +
//                "    }\n" +
//                "\n" +
//                "}");
//        fooWriter.close();

        Generator generator = new Generator();
        generator.gen();
    }
}
