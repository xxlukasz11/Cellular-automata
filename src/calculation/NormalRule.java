package calculation;

public class NormalRule extends Rule {

	public NormalRule(int ruleNumber) {
		super(3);
		this.ruleNumber = ruleNumber;
		this.fillStatesArray();
	}

	private void fillStatesArray() {
		// IMPL: wypelnianie tablicy statesArray bitami zmiennej ruleNumber
	}

	@Override
	public String getRuleString() {
		return String.valueOf(ruleNumber);
	}

	private int ruleNumber;
}
