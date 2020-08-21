package expression;

public class Hypothesis extends AbstractProof {

    private int hypNum;

    public Hypothesis(int number, int hypNum) {
        super(number);
        this.hypNum = hypNum;
    }

    @Override
    String doGet() {
        return "Hypothesis " + (hypNum + 1);
    }
}
