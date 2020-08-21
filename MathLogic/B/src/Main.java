import checker.Checker;
import checker.ProofProvider;
import expression.Expression;
import expression.ProvedExpression;
import javafx.util.Pair;
import parser.ExpressionParser;
import parser.ParseException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    private static Pair<String, String> splitByTurn(String toSplit) {
        StringBuilder first = new StringBuilder();
        for (int i = 0; i < toSplit.length(); ++i) {
            if (toSplit.charAt(i) == '|' && toSplit.charAt(i + 1) == '-') {
                return new Pair<>(first.toString(), toSplit.substring(i + 2));
            }
            first.append(toSplit.charAt(i));
        }
        return null;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ExpressionParser parser = new ExpressionParser();
            List<String> input = bufferedReader.lines().collect(Collectors.toList());
            String firstLine = input.get(0);
            Pair<String, String> hypsStatement = splitByTurn(firstLine);
            input.remove(0);

            AtomicInteger counter = new AtomicInteger();
            List<Expression> hyps;
            if (hypsStatement.getKey().length() != 0) {
                hyps = Arrays.stream(hypsStatement.getKey().split(","))
                        .map(s -> {
                            try {
                                return parser.parse(s);
                            } catch (ParseException e) {
                                e.printStackTrace();
                                return null;
                            }
                        })
                        .collect(Collectors.toList());
            } else {
                hyps = new ArrayList<>();
            }

            Expression statement = parser.parse(hypsStatement.getValue());

            List<Expression> expressions = input.stream()
                    .map(e -> {
                        try {
                            return parser.parse(e);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toList());

            Expression last = expressions.get(expressions.size()-1);
            List<ProvedExpression> provedExpressions = new Checker(statement, hyps, expressions).checkAll();

            if (provedExpressions == null || !statement.equals(last)) {
                System.out.println("Proof is incorrect");
                return;
            }

            //provedExpressions.stream().map(Expression::print).forEach(System.out::println);

            List<ProvedExpression> finaly = new ProofProvider(provedExpressions, statement).getProof();
            if (finaly == null) {
                System.out.println("Proof is incorrect");
                return;
            }

            System.out.print(
                    hyps.stream()
                            .map(Expression::print)
                            .collect(Collectors.joining(", "))
            );
            System.out.print(" |- ");
            System.out.println(statement.print());
            finaly.stream().map(Expression::print).forEach(System.out::println);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
