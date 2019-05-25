import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        //файл, который хранит свойства нашего проекта

        File file = new File(Main.class.getResource("ru.properties").getFile());

        Properties properties = new Properties();
        properties.load(new FileReader(file));
        String st = properties.getProperty("statistics");
        System.out.println(st);
    }
}
