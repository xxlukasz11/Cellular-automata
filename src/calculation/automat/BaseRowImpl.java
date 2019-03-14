package calculation.automat;

public abstract class BaseRowImpl implements Row {

    public BaseRowImpl(int width) {
        this.width = width;
        this.statesArray = new boolean[width];
    }

    @Override
    public double calculateEntropy(int neighbours) {
        var bins = new int[width];
        var it = new NeighbourhoodIterator(statesArray, neighbours);

        while(it.hasNext()){
            int index = it.getNext();
            bins[index]++;
        }

        double entropy = 0.0;
        for(var x : bins){
            if(x != 0){
                double ratio = (double)(x)/width;
                entropy -= ratio*Math.log10(ratio);
            }
        }

        return entropy;
    }

    @Override
    public double calculateDensity(boolean state) {
        int count = 0;
        for(var x : statesArray)
            if(x) count++;
        return (double)(count)/width;
    }

    @Override
    public void setState(int stateIndex, boolean state) {
        if(stateIndex < width)
            statesArray[stateIndex] = state;
    }

    @Override
    public boolean getState(int stateIndex) {
        return statesArray[stateIndex];
    }

    @Override
    public int getWidth() {
        return width;
    }

    protected int width;
    protected boolean[] statesArray;
}
