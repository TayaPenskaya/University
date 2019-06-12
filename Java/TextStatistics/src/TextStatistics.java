import java.io.*;
import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
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


    //Find each sentence in text.
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

        int[] result = new int[5];

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

    //Find each word in text.
    private ArrayList<String> getWordsFromText(String source){
        ArrayList<String> words = new ArrayList<>();
        BreakIterator boundary = BreakIterator.getCharacterInstance(inLocale);
        boundary.setText(source);
        int start = boundary.first();
        for(int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()){
            if(Character.isLetter(source.codePointAt(start))) {
                words.add(source.substring(start, end));
            }
        }
        return words;
    }

    //Getting statistics of words.
    private int[] getWordStatistics(String source){
        int[] result = new int[5];

        ArrayList<String> words = getWordsFromText(source);
//        for(int i = 0; i < words.size(); ++i){
//            System.out.println(i + ": " + words.get(i));
//        }

        //Count the number of words
        result[0] = words.size();

        //Count the number of unique sentences
        result[1] = (int) words.stream().distinct().count();

        //Find the max/min word for character comparison
        String max = words.stream().max(String::compareTo).orElse("");
        System.out.println(max);
        String min = words.stream().min(String::compareTo).orElse("");
        System.out.println(min);

        //Find the max length sentence
        String maxLengthWord = words.stream().reduce(words.get(0), (l,r) -> l.length() > r.length() ? l : r);
        System.out.println(maxLengthWord);
        result[2] = maxLengthWord.length()-1;

        //Find the min length sentence
        String minLengthWord = words.stream().reduce(words.get(0), (l,r) -> l.length() < r.length() ? l : r);
        System.out.println(minLengthWord);
        result[3] = minLengthWord.length()-1;

        int mid = words.stream().map(String::length).reduce((l,r) -> l + r).get();
        result[4] = mid/words.size();

        return result;
    }

    //Find each line in text.
    private List<String> getLinesFromText(String source){
        String[] lines = source.split("\r\n|\r|\n");
        return Arrays.asList(lines);
    }

    // Getting statistics of lines.
    private int[] getLineStatistics(String source) {

        int[] result = new int[5];

        List<String> lines = getLinesFromText(source);
        for(int i = 0; i < lines.size(); ++i){
            System.out.println(i + ": " + lines.get(i));
        }

        //Count the number of sentences
        result[0] = lines.size();

        //Count the number of unique sentences
        result[1] = (int) lines.stream().distinct().count();

        //Find the max length line
        String max = lines.stream().reduce(lines.get(0), (l,r) -> l.length() > r.length() ? l : r);
        System.out.println(max);
        result[2] = max.length()-1;

        //Find the min length line
        String min = lines.stream().reduce(lines.get(0), (l,r) -> l.length() < r.length() ? l : r);
        System.out.println(min);
        result[3] = min.length()-1;

        int mid = lines.stream().map(String::length).reduce((l,r) -> l + r).get();
        result[4] = mid/lines.size();

        return result;
    }

    //Find each number in text
    private ArrayList<Double> getNumbersFromText(String source){
        NumberFormat nf = NumberFormat.getNumberInstance(inLocale);
        BreakIterator boundary = BreakIterator.getLineInstance(inLocale);
        ArrayList<Double> numbers = new ArrayList<>();
        boundary.setText(source);
        int start = boundary.first();
        for(int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()){
            try{
                Number number = nf.parse(source.substring(start,end));
                numbers.add(number.doubleValue());
            }catch (ParseException ignored){

            }
        }
        return numbers;
    }

    private int[] getNumberStatistics(String source){
        int[] result = new int[7];

        ArrayList<Double> numbers = getNumbersFromText(source);
//        for(int i = 0; i < numbers.size(); ++i){
//            System.out.println(i + ": " + numbers.get(i));
//        }

        //Count the number of numbers
        result[0] = numbers.size();

        //Count the number of unique numbers
        result[1] = (int) numbers.stream().distinct().count();

        //Find the max/min number
        Double max = numbers.stream().max(Double::compareTo).orElse(0.0);
        System.out.println(max);
        Double min = numbers.stream().min(Double::compareTo).orElse(0.0);
        System.out.println(min);

        //Find the max length number
        Double maxLength = numbers.stream().reduce(numbers.get(0), (l,r) -> l.toString().length() > r.toString().length() ? l : r);
        System.out.println(maxLength);
        result[2] = maxLength.toString().length();

        //Find the min length number
        Double minLength = numbers.stream().reduce(numbers.get(0), (l,r) -> l.toString().length() < r.toString().length() ? l : r);
        System.out.println(minLength);
        result[3] = minLength.toString().length();

        Double mid = numbers.stream().reduce((l,r) -> l + r).get();

        return result;
    }

    //Find each date in Text
    private ArrayList<TextDate> getDatesFromText(String source){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, inLocale);
        BreakIterator boundary = BreakIterator.getLineInstance(inLocale);
        ArrayList<TextDate> dates = new ArrayList<>();
        boundary.setText(source);
        int start = boundary.first();
        for(int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()){
            try{
                Date date = df.parse(source.substring(start,end));
                dates.add(new TextDate(date, source.substring(start,end)));
            }catch (ParseException ignored){

            }
        }
        return dates;
    }

    //Find each currency in Text
    private ArrayList<TextCurrency> getCurrencyFromText(String source){
        NumberFormat nf = NumberFormat.getCurrencyInstance(inLocale);
        BreakIterator boundary = BreakIterator.getLineInstance(inLocale);
        ArrayList<TextCurrency> currency = new ArrayList<>();
        boundary.setText(source);
        int start = boundary.first();
        for(int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()){
            try{
                Number number = nf.parse(source.substring(start,end));
                currency.add(new TextCurrency(number, source.substring(start,end)));
            }catch (ParseException ignored){

            }
        }
        return currency;
    }

    public void printStatistics() throws IOException {
        ResourceBundle rbIn = ResourceBundle.getBundle("text", inLocale);
        ResourceBundle rbOut = ResourceBundle.getBundle("text", outLocale);

        String inFileContent = fileToString();


        System.out.print(rbOut.getString("analyzedFile"));
        System.out.println(inFilePath);

        System.out.println(rbOut.getString("statistics"));
//        System.out.println(getSentenceStatics(inFileContent)[0]);
//        System.out.println(getSentenceStatics(inFileContent)[1]);
//        System.out.println(getSentenceStatics(inFileContent)[2]);
//        System.out.println(getSentenceStatics(inFileContent)[3]);
//        System.out.println(getSentenceStatics(inFileContent)[4]);
//        System.out.println(getWordStatistics(inFileContent)[0]);
//        System.out.println(getWordStatistics(inFileContent)[1]);
//        System.out.println(getWordStatistics(inFileContent)[2]);
//        System.out.println(getWordStatistics(inFileContent)[3]);
//        System.out.println(getWordStatistics(inFileContent)[4]);
//        System.out.println(getLineStatistics(inFileContent)[0]);
//        System.out.println(getLineStatistics(inFileContent)[1]);
//        System.out.println(getLineStatistics(inFileContent)[2]);
//        System.out.println(getLineStatistics(inFileContent)[3]);
//        System.out.println(getLineStatistics(inFileContent)[4]);
        System.out.println(getNumberStatistics(inFileContent)[0]);
        System.out.println(getNumberStatistics(inFileContent)[1]);
        System.out.println(getNumberStatistics(inFileContent)[2]);
        System.out.println(getNumberStatistics(inFileContent)[3]);
    }
}
