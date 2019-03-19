package ui.options;

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

        controller.setLambda(getLambda());
        controller.setGenerationTime(getGenerationTime());
        controller.setNeighbours(getNeighbours());
        controller.setSize(getSize());
        controller.setRule(getRule());

        // just for test
        Random r = new Random();
        for (int i = 0; i < getGenerationTime(); i++) {
            boolean[] gen0 = new boolean[getSize()];
            for (int j = 0; j < gen0.length; j++) {
                gen0[j] = r.nextBoolean();
            }
            controller.getCanvas().drawOneGeneration(gen0, i);
        }
    }

    public void startSimulation() {
        controller.setupCA();
        // if `rule` radio button is selected... else ...
    }

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

    private double getLambda() {
        try {
            return Double.valueOf(lambdaInput.getText());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int getRule() {
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
    private RadioButton rule;

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
