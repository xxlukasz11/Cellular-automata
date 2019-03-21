package calculation.random;

import java.util.Random;

public class OnesGenerator implements Generator {

	public OnesGenerator(int noOfOnes) {
		this.noOfOnes = noOfOnes;
	}

	@Override
	public void fillArray(boolean[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			if (i < noOfOnes)
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

	private int noOfOnes;
}
