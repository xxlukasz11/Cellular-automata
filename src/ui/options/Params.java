package ui.options;

public class Params {

	public int getTime() {
		return time;
	}

	public int getWidth() {
		return width;
	}

	public int getNoOfOnes() {
		return noOfOnes;
	}

	public int getNeighbours() {
		return neighbours;
	}

	public double getLambda() {
		return lambda;
	}

	public int getRuleNumber() {
		return ruleNumber;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setNoOfOnes(int noOfOnes) {
		this.noOfOnes = noOfOnes;
	}

	public void setNeighbours(int neighbours) {
		this.neighbours = neighbours;
	}

	public void setLambda(double lambda) {
		this.lambda = lambda;
	}

	public void setRuleNumber(int ruleNumber) {
		this.ruleNumber = ruleNumber;
	}

	private int time;
	private int width;
	private int noOfOnes;
	private int neighbours;
	private double lambda;
	private int ruleNumber;
}
