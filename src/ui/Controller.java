package ui;

import javafx.fxml.FXML;
import ui.canvas.CellularCanvas;

public class Controller {

    @FXML
    private CellularCanvas canvas;

    @FXML
    public void initialize() {
        canvas.init();
    }

}
