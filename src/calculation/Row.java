package calculation;

public interface Row {
    double calculateEntropy();
    double calculateDensity(boolean state);
    void fillRandom(double lambda);

    void setState(int stateIndex, boolean state);
    boolean getState(int stateIndex);
    int getWidth();
}
