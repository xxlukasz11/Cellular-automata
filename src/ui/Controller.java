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

    public CellularCanvas getCanvas() {
        return canvas;
    }

    public VBox getContainer() {
        return container;
    }

    @FXML
    private OptionsController optionsController;

    @FXML
    private MenuController menuController;

    @FXML
    private CellularCanvas canvas;

    @FXML
    private VBox container;
}
