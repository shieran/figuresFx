package com.hancharou.figuresFx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Star extends Figure {
    private double base;

    private Star(double cx, double cy, double lineWidth, Color color){
        super(Figure.FIGURE_TYPE_STAR, cx, cy, lineWidth, color);
    }

    public Star(double cx, double cy, double lineWidth, Color color, double base){
        this(cx, cy, lineWidth, color);
        this. base = base < 300 ? 300 : base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Double.compare(star.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }

    @Override
    public void drow(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(
                new double[]{cx, cx + base/10, cx + base/4, cx + base/10, cx + base/6, cx, cx - base/6, cx - base/10, cx - base/4, cx - base/10},
                new double[]{cy - base/5, cy - base/12, cy - base/12, cy + base/12, cy + base/5, cy + base/12, cy + base/5, cy + base/12, cy - base/12, cy - base/12},
                10);
    }
}
