package com.hancharou.figuresFx.controller;

import com.hancharou.figuresFx.figures.*;
import com.hancharou.figuresFx.myOwnExceptions.NullFigureException;
import com.hancharou.figuresFx.myOwnExceptions.UnknownFigureException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {

    private List<Figure> figures = new ArrayList<>();
    private Random random;


    @FXML
    private Canvas canva;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        random = new Random(System.currentTimeMillis());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (UnknownFigureException | NullFigureException e) {
            System.out.println(e.getMessage());
        }
        repaint();
    }

    private Figure createFigure(double x, double y) throws UnknownFigureException {
        Figure figure;
        switch (random.nextInt(7)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(4), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(4), Color.BLUE, random.nextInt(70), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(4), Color.RED, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_IT:
                figure = new SomeFigure(x, y, random.nextInt(4), Color.ORANGE, random.nextInt(750));
                break;
            case Figure.FIGURE_TYPE_STAR:
                figure = new Star(x, y, random.nextInt(4), Color.AQUA, random.nextInt(1000));
                break;
            default:
                throw new UnknownFigureException("Неизвестная фигура");
        }
        return figure;
    }

    private void addFigure(Figure figure) throws NullFigureException {
        if (figure == null) {
            throw new NullFigureException("Пустая фигура не может быть добавлена");
        }
        figures.add(figure);
    }

    private void repaint() {
        canva.getGraphicsContext2D().clearRect(0, 0, canva.getWidth(), canva.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.drawFigures(canva.getGraphicsContext2D());
    }


}
