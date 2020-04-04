package generator;

import java.util.List;

public class StringGenerator {
    private StringBuilder sb;

    private final String TAB = "    ";
    private final String NL = "\n";

    public StringGenerator(StringBuilder sb){
        this.sb = sb;
    }

    public void add(int tabs, String string, int nls){
        sb.append(TAB.repeat(tabs)).append(string).append(NL.repeat(nls));
    }

    public void addManyOnSameLevel(int tabs, List<String> strings){
        for(String string : strings){
            add(tabs, string, 1);
        }
    }

    public StringBuilder getSb() {
        return sb;
    }
}
