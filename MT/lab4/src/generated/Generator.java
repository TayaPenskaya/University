package generated;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    public void gen(){

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("testsCalc")))) {
            List<String> stringList = bufferedReader.lines().collect(Collectors.toList());
            for (String string : stringList){
                CalcParser parser = new CalcParser(string);
                int tree = parser.parse();
                System.out.println(tree);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

}