package ui.options;

import calculation.automat.*;
import calculation.random.Generator;
import calculation.random.OnesGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.Controller;
import ui.exceptions.NotNumberException;
import ui.exceptions.WrongParameterException;

public class OptionsController {

    public void setMainController(Controller controller) {
        this.controller = controller;
    }

    public void startSimulation() {
        Params params;
        try {
            params = getParameters();
        } catch (WrongParameterException | NotNumberException e) {
            showErrorDialog("Error", e.getMessage());
            return;
        }

        setupSimulation(params);
        simulate(params);
    }

    private Params getParameters() throws WrongParameterException, NotNumberException {
        var time = getGenerationTime();
        var width = getSize();
        var ones = getNoOfOnes();
        var neighbours = getNeighbours();

        if (time < 0)
            throw new WrongParameterException("Time cannot be negative");

        if (width < 0)
            throw new WrongParameterException("Width cannot be negative");

        if (ones < 0)
            throw new WrongParameterException("Number of ones cannot be negative");

        if (neighbours < 0 || neighbours > 10)
            throw new WrongParameterException("Number of neighbours must be between 0 and 10");

        if (ones > width)
            throw new WrongParameterException("Number of ones cannot be greater than generation width");

        if (width > controller.getContainer().getWidth()) {
            throw new WrongParameterException("Width of generation is greater than canvas width");
        }

        Params params = new Params();
        params.setTime(time);
        params.setWidth(width);
        params.setNoOfOnes(ones);
        params.setNeighbours(neighbours);

        if (lambdaRadioButton.isSelected()) {
            var lambda = getLambda();
            if (lambda > 1.0 || lambda < 0.0)
                throw new WrongParameterException("Langton parameter must be between 0.0 and 1.0");
            params.setLambda(lambda);
        } else {
            var ruleNumber = getRuleNumber();
            if (ruleNumber < 0 || ruleNumber > 255)
                throw new WrongParameterException("Rule number must be between 0 and 255");
            params.setRuleNumber(ruleNumber);
        }

        return params;
    }

    private void setupSimulation(Params params) {
        controller.getCanvas().widthProperty().bind(controller.getContainer().widthProperty());
        controller.getCanvas().clearCanvas();
        controller.getCanvas().setRasterSize(params.getWidth());
        controller.getCanvas().adjustHeight(params.getTime());
    }

    private void simulate(Params params) {

        Rule rule;

        if (ruleRadioButton.isSelected()) {
            rule = new BasicRule(params.getRuleNumber());
        } else {
            rule = new LambdaRule(params.getNeighbours(), params.getLambda());
        }

        Generator gen = new OnesGenerator(params.getNoOfOnes());
        var init = new InitialGeneration(params.getWidth(), gen);

        var lf = new AutomatLifeCycle(init, rule);
        lf.createGenerations(params.getTime());

        for (var generation : lf.getGenerations()) {
            controller.getCanvas().drawOneGeneration(generation);
        }
    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText("");
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        ruleRadioButton.setSelected(true);
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

    private double getLambda() {
        try {
            return Double.valueOf(lambdaInput.getText());
        } catch (NumberFormatException e) {
            throw new NotNumberException("Cannot convert Langton Parameter to number");
        }
    }

    private int getRuleNumber() {
        try {
            return Integer.valueOf(ruleInput.getText());
        } catch (NumberFormatException e) {
            throw new NotNumberException("Cannot convert rule to number");
        }
    }

    private int getNeighbours() {
        try {
            return Integer.valueOf(neighboursInput.getText());
        } catch (NumberFormatException e) {
            throw new NotNumberException("Cannot convert neighbours to number");
        }
    }

    private int getSize() {
        try {
            return Integer.valueOf(sizeArray.getText());
        } catch (NumberFormatException e) {
            throw new NotNumberException("Cannot convert generation width to number");
        }
    }

    private int getNoOfOnes() {
        try {
            return Integer.valueOf(noOfOnes.getText());
        } catch (NumberFormatException e) {
            throw new NotNumberException("Cannot convert no. of ones to number");
        }
    }

    private int getGenerationTime() {
        try {
            return Integer.valueOf(timeInput.getText());
        } catch (NumberFormatException e) {
            throw new NotNumberException("Cannot convert Time to number");
        }
    }

    private String getInfo() {
        return "INFO:\nBlack cells - alive\nYellow cells - dead";
    }

    @FXML
    private Text lambdaText;

    @FXML
    private TextField lambdaInput;

    @FXML
    private TextField neighboursInput;

    @FXML
    private Text neighbourText;
    @FXML
    private RadioButton ruleRadioButton;

    @FXML
    private RadioButton lambdaRadioButton;

    @FXML
    private Text ruleText;

    @FXML
    private TextField ruleInput;

    @FXML
    private Text info;

    @FXML
    private TextField timeInput;

    @FXML
    private TextField sizeArray;

    @FXML
    private TextField noOfOnes;

    private Controller controller;
}
