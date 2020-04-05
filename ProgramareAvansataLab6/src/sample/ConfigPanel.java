package sample;

import javafx.scene.layout.Pane;

public class ConfigPanel extends Pane {
    public enum ShapeType{
        CIRCLE, POLYGON
    }
    public enum ColorType{
        RED, GREEN, BLUE, RANDOM
    }

    public enum FillType{
        SHAPE, STROKE
    }

    public enum ClickType{
        DRAW, DELETE
    }

    public ConfigPanel() {
        shapeSize = 20;
        selectedShape = ShapeType.CIRCLE;
        colorTypeFill = ColorType.RANDOM;
        colorTypeStroke = ColorType.RANDOM;
        fillType = FillType.SHAPE;
        clickType = ClickType.DRAW;
        nrOfSides = 4;
    }

    private int shapeSize;
    private ShapeType selectedShape;
    private ColorType colorTypeFill;
    private ColorType colorTypeStroke;
    private FillType fillType;
    private ClickType clickType;
    private int nrOfSides;

    public ClickType getClickType() {
        return clickType;
    }

    public void setClickType(ClickType clickType) {
        this.clickType = clickType;
    }

    public ColorType getColorTypeFill() {
        return colorTypeFill;
    }

    public void setColorTypeFill(ColorType colorTypeFill) {
        this.colorTypeFill = colorTypeFill;
    }

    public ColorType getColorTypeStroke() {
        return colorTypeStroke;
    }

    public void setColorTypeStroke(ColorType colorTypeStroke) {
        this.colorTypeStroke = colorTypeStroke;
    }

    public FillType getFillType() {
        return fillType;
    }

    public void setFillType(FillType fillType) {
        this.fillType = fillType;
    }

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

    public int getNrOfSides() {
        return nrOfSides;
    }

    public void setNrOfSides(int nrOfSides) {
        this.nrOfSides = nrOfSides;
    }
}
