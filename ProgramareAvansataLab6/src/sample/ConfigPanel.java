package sample;

import javafx.scene.layout.Pane;

public class ConfigPanel extends Pane {
    public enum ShapeType{
        CIRCLE,
    }

    public ConfigPanel() {
        shapeSize = 100;
        selectedShape = ShapeType.CIRCLE;
    }

    private int shapeSize;
    private ShapeType selectedShape;

    public ShapeType getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(ShapeType selectedShape) {
        this.selectedShape = selectedShape;
    }

    void setShapeSize(int size){
        shapeSize = size;
    }

    public int getShapeSize() {
        return shapeSize;
    }
}
