package calculation;

public class RandomRule extends Rule {

	public RandomRule(int neighbours, double lambda) {
		super(neighbours);
		this.lambda = lambda;

		this.fillRandom(lambda);
	}

	@Override
	public String getRuleString() {
		return ruleString;
	}

	private void setRuleString(){
		// IMPL: zapisanie do zmiennej ruleString, stringa z hexem reguly, na podstawie statesArray
	}

	private double lambda;
	String ruleString;
}
