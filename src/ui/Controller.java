package ui;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import ui.canvas.CellularCanvas;
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
    private CellularCanvas canvas;

    @FXML
    private VBox container;
}
