package ui.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CellularCanvas extends Canvas {

    public void drawOneGeneration(boolean[] array, int generationNumber) {
        gc = this.getGraphicsContext2D();
        int width = (int) (this.getWidth() / array.length);
        for (int i = 0; i < array.length; ++i) {
            drawCell(gc, array[i], i * width, generationNumber * width, width, width);
        }
    }

    private void drawCell(GraphicsContext gc, boolean alive, int x, int y, int width, int height) {
        gc.setFill(alive ? Color.BLACK : Color.YELLOW);
        gc.fillRect(x, y, width, height);
    }

    public void clearCanvas() {
        gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    private GraphicsContext gc;
}
