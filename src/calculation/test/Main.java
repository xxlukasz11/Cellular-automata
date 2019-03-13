package calculation.test;

import calculation.AutomatLifeCycle;
import calculation.InitialGeneration;
import calculation.NormalRule;

public class Main {

	// Example of use

	public static void main(String[] args){
		int width = 10;

		var rule  = new NormalRule(90);
		var init = new InitialGeneration(width);

		init.fillRandom(0.4);
		// lub
		// init.setState(2, true);


		var lf = new AutomatLifeCycle(width, rule, init);
		lf.createGenerations(10);

		var generations = lf.getGenerations();
		for(var row : generations){
			for(var cell : row.getCells())
				System.out.print( cell ? "*" : " ");
			System.out.println();
		}
	}
}
