package ui.options;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.exceptions.NotNumberException;

public class OptionsController {

    @FXML
    public void initialize() {
        rule.setSelected(true);
        disableRadioButton(true);
        info.setText(getInfo());
    }

    public void disableLambda() {
        disableRadioButton(true);
    }

    public void disableRule() {
        disableRadioButton(false);
    }

    private void disableRadioButton(boolean isLambda) {
        lambdaText.setDisable(isLambda);
        lambdaInput.setDisable(isLambda);
        neighboursInput.setDisable(isLambda);
        neighbourText.setDisable(isLambda);

        ruleText.setDisable(!isLambda);
        ruleInput.setDisable(!isLambda);
    }

    public double getLambda() {
        try {
            return Double.valueOf(lambdaInput.getText());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getRule() {
        try {
            int rule = Integer.valueOf(ruleInput.getText());
            if (rule >= 0 && rule <= 255)
                return rule;
            else
                System.out.println("Specify rule in range 0-255");
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getNeighbours() {
        try {
            return Integer.valueOf(neighboursInput.getText());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public String getInfo() {
        return "INFO:\nBlack cells - alive\nYellow cells - dead";
    }

    @FXML
    private Text lambdaText;

    @FXML
    private TextField lambdaInput;

    @FXML
    private Text neighbourText;

    @FXML
    private TextField neighboursInput;

    @FXML
    private RadioButton rule;

    @FXML
    private Text ruleText;

    @FXML
    private TextField ruleInput;

    @FXML
    private Text info;

}
