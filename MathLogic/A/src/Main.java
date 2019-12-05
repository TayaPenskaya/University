import parser.ExpressionParser;
import parser.ParseException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        ExpressionParser parser = new ExpressionParser(expression);
        System.out.println(parser.parse().print());
    }
}
