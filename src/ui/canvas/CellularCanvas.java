package ui.canvas;

import calculation.automat.Generation;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CellularCanvas extends Canvas {

    public void drawOneGeneration(Generation generation) {
        gc = this.getGraphicsContext2D();
        for (int i = 0; i < generation.getWidth(); ++i) {
            drawCell(gc, generation.getState(i), i * rasterSize, generation.getId() * rasterSize, rasterSize, rasterSize);
        }
    }

    private void drawCell(GraphicsContext gc, boolean alive, int x, int y, int width, int height) {
        gc.setFill(alive ? Color.BLACK : Color.WHITE);
        gc.fillRect(x, y, width, height);
    }

    public void clearCanvas() {
        gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void setRasterSize(int width) {
        rasterSize = (int) (this.getWidth() / width);
    }

    public void adjustHeight(int time) {
        setHeight(rasterSize * time);
    }

    private GraphicsContext gc;
    private int rasterSize;
}
