package expression;

public class Axiom extends AbstractProof {

    private int axNum;

    public Axiom(int number, int axNum) {
        super(number);
        this.axNum = axNum;
    }

    @Override
    String doGet() {
        return "Ax. sch. " + (axNum + 1);
    }
}
