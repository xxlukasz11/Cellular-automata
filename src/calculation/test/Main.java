package calculation.test;

import calculation.automat.AutomatLifeCycle;
import calculation.automat.InitialGeneration;
import calculation.automat.BasicRule;
import calculation.automat.LambdaRule;
import calculation.random.Generator;
import calculation.random.LambdaGenerator;

public class Main {

	// Example of use

	public static void main(String[] args){
		int width = 10;

		Generator gen = new LambdaGenerator(0.4);
		var rule  = new BasicRule(90);
		var ruler  = new LambdaRule(3,0.3);
		var init = new InitialGeneration(width, gen);

		var lf = new AutomatLifeCycle(init, rule);
		lf.createGenerations(10);

		var generations = lf.getGenerations();
		for(var row : generations){
			var cells = row.getCells();
			for(var cell : cells)
				System.out.print( cell ? "*" : " ");
			System.out.println();
		}
	}
}
