import gen.FunctionLexer;
import gen.FunctionParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("tests")))) {
            String expression = bufferedReader.lines().collect(Collectors.joining("\n"));
            FunctionLexer lexer = new FunctionLexer(new ANTLRInputStream(expression));
            FunctionParser parser = new FunctionParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.code();
            System.out.println(new FunctionMainVisitor().visit(tree));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
