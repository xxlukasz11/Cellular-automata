package calculation.automat;

public interface Row {
    double calculateEntropy(int neighbours);
    double calculateDensity(boolean state);

    void setState(int stateIndex, boolean state);
    boolean getState(int stateIndex);
    int getWidth();
}
