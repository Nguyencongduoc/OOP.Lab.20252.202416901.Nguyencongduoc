package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioBtnPen;

    @FXML
    private RadioButton radioBtnEraser;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        Circle dot;
        if (radioBtnEraser.isSelected()) {
            // Eraser: draw a larger white circle to "erase"
            dot = new Circle(x, y, 8, Color.WHITE);
        } else {
            // Pen: draw a small black circle
            dot = new Circle(x, y, 4, Color.BLACK);
        }
        drawingAreaPane.getChildren().add(dot);
    }

    @FXML
    void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}