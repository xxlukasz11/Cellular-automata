package calculation.automat;

public class BasicRule extends Rule {

	public BasicRule(int ruleNumber) {
		super(3);
		this.ruleNumber = ruleNumber;

		this.fillStatesArray();
	}

	@Override
	protected void fillStatesArray() {
		// IMPL: wypelnianie tablicy statesArray bitami zmiennej ruleNumber
	}

	@Override
	public String getRuleString() {
		return String.valueOf(ruleNumber);
	}

	private final int ruleNumber;
}
