import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        TextStatistics ts = new TextStatistics(args[0], args[1], args[2], args[3]);

        ts.printStatistics();
    }
}
