package ui;

import javafx.fxml.FXML;
import ui.canvas.CellularCanvas;
import ui.menu.MenuController;
import ui.options.OptionsController;

public class Controller {

    @FXML
    public void initialize() {
        canvas.init();
    }

    @FXML
    private OptionsController optionsController;

    @FXML
    private MenuController menuController;

    @FXML
    private CellularCanvas canvas;
}
