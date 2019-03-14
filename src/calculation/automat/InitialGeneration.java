package calculation.automat;

import calculation.random.Generator;

public class InitialGeneration extends Generation {
	public InitialGeneration(int width, Generator generator) {
		super(width, 0);
		this.generator = generator;

		this.fillRandom();
	}

	public void fillRandom(){
		generator.fillArray(statesArray);
	}

	private final Generator generator;
}
