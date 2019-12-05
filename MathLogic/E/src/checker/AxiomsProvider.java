package checker;

import expression.Expression;
import parser.ExpressionParser;
import parser.ParseException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AxiomsProvider {

    private List<Expression> axioms;

    public List<Expression> getAxioms() {
        return axioms;
    }

    AxiomsProvider() {
        ExpressionParser parser = new ExpressionParser(true);
        axioms =
                Stream.of("(a -> (b -> a))",
                        "((a -> b) -> ((a -> (b -> c)) -> (a -> c)))",
                        "(a -> (b -> (a & b)))",
                        "((a & b) -> a)",
                        "((a & b) -> b)",
                        "(a -> (a | b))",
                        "(b -> (a | b))",
                        "((a -> c) -> ((b -> c) -> ((a | b) -> c)))",
                        "((a -> b) -> ((a -> !b) -> !a))",
                        "!!a->a"
                ).map(e -> {
                    try {
                        return parser.parse(e);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());

        ExpressionParser parser1 = new ExpressionParser(false);
        List<Expression> newAx =
                Stream.of("a = b -> a' = b'",
                        "a = b -> a = c -> b = c",
                        "a' = b' -> a = b",
                        "!a' = 0",
                        "a + b' = (a+b)'",
                        "a + 0 = a",
                        "a * 0 = 0",
                        "a * b' = a * b + a"
                ).map(e -> {
                    try {
                        return parser1.parse(e);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());

        axioms.addAll(newAx);
    }
}
