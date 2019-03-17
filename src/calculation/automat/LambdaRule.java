package calculation.automat;

import calculation.random.LambdaGenerator;

import java.util.ArrayList;
import java.util.List;

public class LambdaRule extends Rule {

    public LambdaRule(int neighbours, double lambda) {
        super(neighbours);
        this.lambda = lambda;

        this.fillStatesArray();
        this.setRuleString();
    }

    @Override
    protected void fillStatesArray() {
        var gen = new LambdaGenerator(lambda, neighbours);
        gen.fillArray(statesArray);
    }

    @Override
    public String getRuleString() {
        return ruleString;
    }

    private void setRuleString() {
        List<String> hexes = new ArrayList<>();

        for (int i = 0; i < width / 8; ++i) {
            int bt = 0;
            for (int j = 0; j < 8; ++j) {
                statesArray[8 * i + j] = true;
                if (statesArray[8 * i + j])
                    bt |= (1 << j);
            }
            hexes.add(Integer.toHexString(bt));
        }
        ruleString = String.join(" ", hexes);
    }

    private final double lambda;
    private String ruleString;
}
