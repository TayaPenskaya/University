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
        ExpressionParser parser = new ExpressionParser();
        axioms =
        Stream.of("(A -> (B -> A))",
                "((A -> B) -> ((A -> (B -> C)) -> (A -> C)))",
                "(A -> (B -> (A & B)))",
                "((A & B) -> A)",
                "((A & B) -> B)",
                "(A -> (A | B))",
                "(B -> (A | B))",
                "((A -> C) -> ((B -> C) -> ((A | B) -> C)))",
                "((A -> B) -> ((A -> !B) -> !A))",
                "!!A->A"
                ).map(e -> {
            try {
                return parser.parse(e);
            } catch (ParseException ex) {
                ex.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());

    }
}
