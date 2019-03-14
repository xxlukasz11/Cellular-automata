package calculation.automat;

public abstract class Rule extends BaseRowImpl {

    Rule(int neighbours) {
        super( (int)Math.pow(2, neighbours) );
        this.neighbours = neighbours;
    }

    protected abstract void fillStatesArray();
    public abstract String getRuleString();

    protected int neighbours;
}
