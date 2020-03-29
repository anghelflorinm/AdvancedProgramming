package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

public class DrawingPanel extends Pane {


    public void setConfigPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    public DrawingPanel() {

    }

    ConfigPanel configPanel;

    public DrawingPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    private void clearScreen(){
        this.getChildren().clear();
    }

    private Shape getDrawShape(double x, double y){
        switch (configPanel.getSelectedShape()){
            case CIRCLE:
                Circle circle = new Circle();
                circle.setRadius(configPanel.getShapeSize());
                circle.setCenterX(x);
                circle.setCenterY(y);
                return circle;
        }
        return new Circle();
    }

    public void drawShape(double x, double y){
        Shape shape = getDrawShape(x, y);
        Color color = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        shape.setFill(color);
        this.getChildren().addAll(shape);
    }
}
