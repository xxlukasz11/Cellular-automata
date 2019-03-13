package calculation;

public abstract class BaseRowImpl implements Row {

    public BaseRowImpl(int width) {
        this.width = width;
        this.statesArray = new boolean[width];
    }

    @Override
    public double calculateEntropy() {
        // IMPL: entropia jednego rzedu
        return 0.0;
    }

    @Override
    public double calculateDensity(boolean state) {
        // IMPL: gestosc stanu state w danym rzedzie
        return 0.0;
    }

    @Override
    public void fillRandom(double lambda) {
        // IMPL: wstawianie jedynek wedlug parametru lambda do statesArray
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
