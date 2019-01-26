package com.hancharou.figuresFx.figures;

import javafx.scene.canvas.GraphicsContext;

public class SomeFigure extends Figure {


    @Override
    public void drow(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(lineWidth);
        gc.strokePolygon();
    }
}
