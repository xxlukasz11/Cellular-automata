package calculation.automat;

import calculation.random.LambdaGenerator;

import java.util.ArrayList;
import java.util.Collections;
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
        var gen = new LambdaGenerator(lambda);
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
                if (statesArray[8 * i + j])
                    bt |= (1 << j);
            }
            hexes.add(Integer.toHexString(bt));
        }

        Collections.reverse(hexes);
        ruleString = String.join(" ", hexes);
    }

    private final double lambda;
    private String ruleString;
}
