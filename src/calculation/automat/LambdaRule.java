package calculation.automat;

public class LambdaRule extends Rule {

	public LambdaRule(int neighbours, double lambda) {
		super(neighbours);
		this.lambda = lambda;

		this.fillStatesArray();
		this.setRuleString();
	}

	@Override
	protected void fillStatesArray() {
		// IMPL: losowanie na podstawie lambdy
	}

	@Override
	public String getRuleString() {
		return ruleString;
	}

	private void setRuleString(){
		// IMPL: zapisanie do zmiennej ruleString, stringa z hexem reguly, na podstawie statesArray
	}

	private final double lambda;
	private String ruleString;
}
