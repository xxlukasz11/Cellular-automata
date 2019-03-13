package ui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;

public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private RadioButton langton;

    @FXML
    public void initialize() {
        // some random graphics
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillRect(10, 10, 200, 200);

        langton.setSelected(true);
    }


}
