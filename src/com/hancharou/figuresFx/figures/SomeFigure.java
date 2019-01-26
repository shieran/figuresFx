package com.hancharou.figuresFx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class SomeFigure extends Figure {

    private double base;

    private SomeFigure(double cx, double cy, double lineWidth, Color color){
        super(Figure.FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public SomeFigure(double cx, double cy, double lineWidth, Color color, double base){
        this(cx, cy, lineWidth, color);
        this.base = base < 300 ? 300 : base;
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
        SomeFigure that = (SomeFigure) o;
        return Double.compare(that.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(
                new double[]{cx - base/3, cx - base/6, cx - base/6, cx - base/4.5, cx - base/4.5, cx - base/6, cx - base/6, cx - base/3, cx - base/3, cx - base/3.5, cx - base/3.5, cx - base/3},
                new double[]{cy - base/4, cy - base/4, cy - base/7, cy - base/7, cy - base/8, cy - base/8, cy + base/5, cy + base/5, cy - base/8, cy - base/8, cy - base/7, cy - base/7},
                12);
        gc.strokePolygon(
                new double[]{cx, cx + base/3.8, cx + base/3.8, cx + base/5.5, cx + base/5.5, cx + base/12, cx + base/12, cx},
                new double[]{cy - base/4, cy - base/4, cy - base/7, cy - base/7, cy + base/5, cy + base/5, cy - base/7, cy - base/7},
                8);
    }
}
