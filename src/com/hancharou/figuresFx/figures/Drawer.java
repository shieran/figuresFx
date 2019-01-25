package com.hancharou.figuresFx.figures;
import com.hancharou.figuresFx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Figure & Drowable> {
    List<T> figures;

    public Drawer(List<T> figures) {
        this.figures = figures;
    }

    public void drawFigures(GraphicsContext gs) {
        for (T figure : figures) {
            if (figure != null) {
                figure.drow(gs);
            }
        }

    }

}