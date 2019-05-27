import java.io.*;
import java.text.BreakIterator;
import java.util.*;

public class TextStatistics {

    Locale inLocale;
    Locale outLocale;
    String inFilePath;
    String outFilePath;

    public TextStatistics(String inLocale, String outLocale, String inFilePath, String outFilePath) {
        this.inLocale = new Locale(inLocale);
        this.outLocale = new Locale(outLocale);
        this.inFilePath = inFilePath;
        this.outFilePath = outFilePath;
    }

    // Read string out of input file.
    public String fileToString() throws IOException{
        InputStream inFile = this.getClass().getResourceAsStream(inFilePath);
        BufferedReader buf = new BufferedReader(new InputStreamReader(inFile));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
        return fileAsString;

    }

    // Getting statistics of sentences.
    private int[] getSentenceStatics(String target) {

        int[] result = new int[7];

        // Number of sentences.
        BreakIterator iterator = BreakIterator.getSentenceInstance(inLocale);
        StringBuffer markers = new StringBuffer();
        markers.setLength(target.length() + 1);
        for (int k = 0; k < markers.length(); k++) {
            markers.setCharAt(k, ' ');
        }
        int count = 0;
        iterator.setText(target);
        int boundary = iterator.first();
        while (boundary != BreakIterator.DONE) {
            markers.setCharAt(boundary, '^');
            ++count;
            boundary = iterator.next();
        }
        result[0] = count - 1;

        // Number of unique sentences.
        ArrayList<String> sentences = new ArrayList<>(Arrays.asList(target.split("[.?!]+")));
        result[1] = (int) sentences.stream().distinct().count();

        return result;
    }






    public void printStatistics() throws IOException {
        ResourceBundle rbIn = ResourceBundle.getBundle("text", inLocale);
        ResourceBundle rbOut = ResourceBundle.getBundle("text", outLocale);

        String inFileContent = fileToString();


        System.out.print(rbOut.getString("analyzedFile"));
        System.out.println(inFilePath);

        System.out.println(rbOut.getString("statistics"));
        System.out.println(getSentenceStatics(inFileContent)[0]);

        System.out.println(getSentenceStatics(inFileContent)[1]);
    }
}
