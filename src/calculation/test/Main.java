package calculation.test;

import calculation.automat.*;
import calculation.random.Generator;
import calculation.random.LambdaGenerator;

public class Main {

	// Example of use

	public static void main(String[] args){
		Generator gen = new LambdaGenerator(0.4);
		var rule  = new BasicRule(90);
		var init = new InitialGeneration(40, gen);
		init.setState(10,true);

		var lf = new AutomatLifeCycle(init, rule);
		lf.createGenerations(40);


		// draw
		var generations = lf.getGenerations();
		for(var row : generations){

			// draw cells
			var cells = row.getCells();
			for(var cell : cells)
				System.out.print( cell ? "*" : " ");

			// draw entropy plot
			int ent = (int)(row.calculateEntropy(rule.getNeighbours())*10);
			System.out.print("|");
			for(int i = 0; i < ent; ++i)
				System.out.print(" ");
			System.out.println(".");
		}
	}
}
