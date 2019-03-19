package ui;

import calculation.automat.AutomatLifeCycle;
import calculation.automat.InitialGeneration;
import calculation.automat.LambdaRule;
import calculation.random.Generator;
import calculation.random.LambdaGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import ui.canvas.CellularCanvas;
import ui.menu.MenuController;
import ui.options.OptionsController;

public class Controller {

    @FXML
    public void initialize() {
        optionsController.setMainController(this);
    }

    public void setupCA() {
        // TODO: check what radioButton is selected and implement logic
        System.out.println("\n\tSimulation starts...");
        System.out.println("\tSize: " + size + "\tGeneration time: " + generationTime);
        System.out.println("\tNeighbours: " + neighbours);

        Generator gen = new LambdaGenerator(lambda);
        var init = new InitialGeneration(size, gen);

        var lRule = new LambdaRule(neighbours, lambda);
        var lf = new AutomatLifeCycle(init, lRule);
        lf.createGenerations(generationTime);
    }

    public CellularCanvas getCanvas() {
        return canvas;
    }

    public VBox getContainer() {
        return container;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public void setGenerationTime(int generationTime) {
        this.generationTime = generationTime;
    }

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

    @FXML
    private OptionsController optionsController;

    @FXML
    private MenuController menuController;

    @FXML
    private CellularCanvas canvas;

    @FXML
    private VBox container;

    private int size;

    private int neighbours;

    private int generationTime;

    private int rule;

    private double lambda;
}
