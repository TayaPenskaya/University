import java.io.*;
import java.text.BreakIterator;
import java.util.*;

import static java.util.Collections.*;

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


    //Find each sentence in text
    private ArrayList<String> getSentencesFromText(String source){
        ArrayList<String> sentences = new ArrayList<>();
        BreakIterator boundary = BreakIterator.getSentenceInstance(inLocale);
        boundary.setText(source);
        int start = boundary.first();
        for(int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()){
            sentences.add(source.substring(start, end));
        }
        return sentences;
    }

    // Getting statistics of sentences.
    private int[] getSentenceStatics(String source) {

        int[] result = new int[7];

        ArrayList<String> sentences = getSentencesFromText(source);
//        for(int i = 0; i < sentences.size(); ++i){
//            System.out.println(i + ": " + sentences.get(i));
//        }

        //Count the number of sentences
        result[0] = sentences.size();

        //Count the number of unique sentences
        result[1] = (int) sentences.stream().distinct().count();

        //Find the max length sentence
        String max = sentences.stream().reduce(sentences.get(0), (l,r) -> l.length() > r.length() ? l : r);
        System.out.println(max);
        result[2] = max.length()-1;

        //Find the min length sentence
        String min = sentences.stream().reduce(sentences.get(0), (l,r) -> l.length() < r.length() ? l : r);
        System.out.println(min);
        result[3] = min.length()-1;

        int mid = sentences.stream().map(String::length).reduce((l,r) -> l + r).get();
        result[4] = mid/sentences.size();

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
        System.out.println(getSentenceStatics(inFileContent)[2]);
        System.out.println(getSentenceStatics(inFileContent)[3]);
        System.out.println(getSentenceStatics(inFileContent)[4]);
    }
}
