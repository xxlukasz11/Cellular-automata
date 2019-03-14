package calculation.random;

public class LambdaGenerator implements Generator{

	public LambdaGenerator(double lambda) {
		this.lambda = lambda;
	}

	@Override
	public void fillArray(boolean[] array) {
		// IMPL: wypelnianie na podstawie lambdy
	}

	private double lambda;
}
