package calculation;

public abstract class Rule extends BaseRowImpl {

    Rule(int neighbours) {
        super( (int)Math.pow(2, neighbours) );
        this.neighbours = neighbours;
    }

    public abstract String getRuleString();

    private int neighbours;
}
