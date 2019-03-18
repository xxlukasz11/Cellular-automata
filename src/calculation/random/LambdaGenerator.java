package calculation.random;

import java.util.Random;

public class LambdaGenerator implements Generator {

    public LambdaGenerator(double lambda, int neighbours) {
        this.lambda = lambda;
        this.neighbours = neighbours;
    }

    @Override
    public void fillArray(boolean[] array) {
        // Lambda = c / 2^k
        // where: c - no. of ones, k - no. of neighbours
        int c = (int) (lambda * Math.pow(2, 2 * neighbours + 1));
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            if (i < c)
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

    private int neighbours;
}
