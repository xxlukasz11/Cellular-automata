package calculation.random;

import java.util.Random;

public class RandomGenerator implements Generator {

    @Override
    public void fillArray(boolean[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextBoolean();
        }
    }
}
