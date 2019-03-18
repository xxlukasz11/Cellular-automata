package ui.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CellularCanvas extends Canvas {

    public void init() {
        GraphicsContext gc = this.getGraphicsContext2D();
        // random boolean array
        boolean[] array = {true, true, false, false, true};
        int size = (int) (this.getWidth() / array.length); // ?
        System.out.println(size);
        for (int i = 0; i < array.length; i++) {
            drawCell(gc, array[i], size * i, 0, size, size);
        }
    }

    private void drawCell(GraphicsContext gc, boolean alive, int x, int y, int width, int height) {
        gc.setFill(alive ? Color.BLACK : Color.YELLOW);
        gc.fillRect(x, y, width, height);
    }
}
