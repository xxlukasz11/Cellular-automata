package calculation.automat;

public class BasicRule extends Rule {

	public BasicRule(int neighbours, int ruleNumber) {
		super(neighbours);
		this.ruleNumber = ruleNumber;

		this.fillStatesArray();
	}

	@Override
	protected void fillStatesArray() {
		for(int i = 0; i < 8; ++i) {
			if ( (ruleNumber & (1 << i)) != 0 ) {
				statesArray[i] = true;
			}
		}
	}

	@Override
	public String getRuleString() {
		return String.valueOf(ruleNumber);
	}

	private final int ruleNumber;
}
