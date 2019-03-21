package calculation.random;

import java.util.Random;

public class LambdaGenerator implements Generator {

    public LambdaGenerator(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public void fillArray(boolean[] array) {
        int noOfOnes = (int) (lambda*array.length);
        var gen = new OnesGenerator(noOfOnes);
        gen.fillArray(array);
    }

    private double lambda;
}
