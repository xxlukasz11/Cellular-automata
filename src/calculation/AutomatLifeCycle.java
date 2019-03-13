package calculation;

import java.util.List;

public class AutomatLifeCycle {

	public AutomatLifeCycle(int automatWidth, Rule rule, InitialGeneration initialGeneration){
		this.automatWidth = automatWidth;
		this.rule = rule;
		this.currentTime = 1;

		this.generations.add(initialGeneration);
		this.lastGeneration = generations.get(0); // zeby trzymac w tej zmiennej tylko referencje a nie kopie
	}

	public List<Generation> getGenerations(){
		return generations;
	}

	public void createGenerations(int count){
		for(int i = 0; i < count; ++i)
			addNext();
	}

	private void addNext(){
		var nextGen = getNext();
		generations.add( nextGen );
		lastGeneration = generations.get( generations.size()-1 );
		incrementTime();
	}

	private Generation getNext(){
		Generation nextGeneration = new Generation(automatWidth, currentTime);

		// IMPL: kod tworzacy nastepna generacje na podstawie rule
		// tworzymy liczbe z bitow na podstawie sasiedztwa i uzywamy metody rule.getState(int)

		return nextGeneration;
	}

	private void incrementTime(){
		currentTime++;
	}

	private final int automatWidth;
	private final Rule rule;

	private int currentTime;
	private List<Generation> generations;
	private Generation lastGeneration;
}
