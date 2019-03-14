package ui.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CellularCanvas extends Canvas {

    // TODO: implement logic of CA

    public void init() {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.fillRect(20, 20, 200, 400);
    }
}
