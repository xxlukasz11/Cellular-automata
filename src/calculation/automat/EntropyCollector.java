package calculation.automat;

import calculation.random.Generator;
import calculation.random.LambdaGenerator;
import calculation.random.OnesGenerator;

import java.util.ArrayList;
import java.util.List;

public class EntropyCollector {

	public EntropyCollector(Rule rule, int width){
		this.rule = rule;
		this.width = width;
		gen = new OnesGenerator(width/2);
	}

	public double calculateAverageEntropy(int automataCount){
		int time = width*10;

		List<Double> entropiesOfAutomata = new ArrayList<>(automataCount);

		for(int i = 0; i < automataCount; ++i){
			var lf = new AutomatLifeCycle(new InitialGeneration(width, gen), rule);

			List<Double> entropiesOfGenerations = new ArrayList<>(time);
			for(int j = 0; j < time; ++j){
				var entropy = lf.createNext().calculateEntropy(rule.getNeighbours());
				entropiesOfGenerations.add(entropy);
			}

			entropiesOfAutomata.add( entropiesOfGenerations.stream().mapToDouble(a -> a).average().orElse(0.0) );
		}

		return entropiesOfAutomata.stream().mapToDouble(a -> a).average().orElse(0.0);
	}

	private Rule rule;
	private int width;
	private Generator gen;
}
