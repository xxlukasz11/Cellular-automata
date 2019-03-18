package calculation.random;

import java.util.Random;

public class LambdaGenerator implements Generator {

    public LambdaGenerator(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public void fillArray(boolean[] array) {
        int nOfOnes = (int) (lambda*array.length);

        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            if (i < nOfOnes)
                array[i] = true;
            else
                array[i] = false;
        }
        // shuffle
        for (int i = 0; i < array.length; i++) {
            int randomPos = r.nextInt(array.length);
            boolean tmp = array[i];
            array[i] = array[randomPos];
            array[randomPos] = tmp;
        }
    }

    private double lambda;
}
