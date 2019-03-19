package ui.options;

import calculation.automat.*;
import calculation.random.Generator;
import calculation.random.LambdaGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.Controller;
import ui.exceptions.NotNumberException;

import java.util.Random;

public class OptionsController {

    public void setMainController(Controller controller) {
        this.controller = controller;
    }

    public void setupSimulation() {
        controller.getCanvas().widthProperty().bind(controller.getContainer().widthProperty());
        controller.getCanvas().clearCanvas();
        controller.getCanvas().setRasterSize(getSize());
        controller.getCanvas().adjustHeight(getGenerationTime());
    }

    public void startSimulation() {
        setupSimulation();

        Rule rule;

        if(ruleRadioButton.isSelected()){
            rule = new BasicRule(getRuleNumber());
        }
        else{
            rule = new LambdaRule(getNeighbours(), getLambda());
        }

        Random r = new Random();
        Generator gen = new LambdaGenerator(r.nextDouble());
        var init = new InitialGeneration(getSize(), gen);

        var lf = new AutomatLifeCycle(init, rule);
        lf.createGenerations(getGenerationTime());

        for (var generation : lf.getGenerations()) {
            controller.getCanvas().drawOneGeneration(generation);
        }
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
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int getRuleNumber() {
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

    private int getNeighbours() {
        try {
            return Integer.valueOf(neighboursInput.getText());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int getSize() {
        try {
            return Integer.valueOf(sizeArray.getText());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int getGenerationTime() {
        try {
            return Integer.valueOf(timeInput.getText());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private String getInfo() {
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

    private Controller controller;
}
