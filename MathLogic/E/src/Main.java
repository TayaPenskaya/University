import checker.Checker;
import expression.Expression;
import javafx.util.Pair;
import parser.ExpressionParser;
import parser.ParseException;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
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

    private static List<String> splitHyps(String str) {
        List<String> hyps = new ArrayList<>();
        int lbr = 0;
        int rbr = 0;
        int start = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') ++lbr;
            if (str.charAt(i) == ')') ++rbr;
            if ((str.charAt(i) == ',') && (lbr == rbr)) {
                hyps.add(str.substring(start, i));
                start = i + 1;
            }
        }
        hyps.add(str.substring(start));
        return hyps;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ExpressionParser parser = new ExpressionParser(false);
            List<String> input = bufferedReader.lines().collect(Collectors.toList());
            String firstLine = input.get(0);
            Pair<String, String> hypsStatement = splitByTurn(firstLine);
            input.remove(0);

            AtomicInteger counter = new AtomicInteger();
            Map<Expression, Integer> hyps;
            if (hypsStatement.getKey().length() != 0) {
                hyps = splitHyps(hypsStatement.getKey()).stream()
                        .map(s -> {
                            try {
                                return parser.parse(s);
                            } catch (ParseException e) {
                                e.printStackTrace();
                                return null;
                            }
                        })
                        .collect(Collectors.toMap(Function.identity(), e -> counter.getAndIncrement()));
            } else {
                hyps = new HashMap<>();
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

//            System.out.println(statement.print());
//            expressions.stream().map(Expression::print).forEach(System.out::println);

            Checker checker = new Checker(statement, hyps, expressions);
            checker.checkAll();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
