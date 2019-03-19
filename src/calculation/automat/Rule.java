package calculation.automat;

public abstract class Rule extends BaseRowImpl {

    Rule(int neighbours) {
        super( (int)Math.pow(2, 2*neighbours+1) );
        this.neighbours = neighbours;
    }

    public int getNeighbours() {
        return neighbours;
    }

    protected abstract void fillStatesArray();
    public abstract String getRuleString();

    protected int neighbours;
}
