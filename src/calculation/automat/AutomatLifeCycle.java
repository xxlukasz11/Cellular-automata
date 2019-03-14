package calculation.automat;

import java.util.ArrayList;
import java.util.List;

public class AutomatLifeCycle {

	public AutomatLifeCycle(InitialGeneration initialGeneration, Rule rule){
		this.automatWidth = initialGeneration.getWidth();
		this.rule = rule;
		this.currentTime = 1;

		this.generations = new ArrayList<>();
		this.generations.add(initialGeneration);
		this.lastGeneration = generations.get(0);
	}

	public void createGenerations(int count){
		for(int i = 0; i < count; ++i)
			addNext();
	}

	private void addNext(){
		var nextGen = createNext();
		generations.add( nextGen );
		lastGeneration = generations.get( generations.size()-1 );
		incrementTime();
	}

	private Generation createNext(){
		Generation nextGeneration = new Generation(automatWidth, currentTime);

		var it = new NeighbourhoodIterator(lastGeneration.getCells(), rule.getNeighbours());

		for(int i = 0; it.hasNext(); ++i){
			int index = it.getNext();
			nextGeneration.setState(i, rule.getState(index));
		}
		return nextGeneration;
	}

	public List<Generation> getGenerations(){
		return generations;
	}

	public int getGenerationsCount(){
		return generations.size();
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
