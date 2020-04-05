package sample;

public class DrawShape {
    private double centerX;
    private double centerY;
    private int radius;
    private int nrSides;
    private ConfigPanel.ShapeType shapeType;
    double[] coordX;
    double[] coordY;

    public DrawShape(double centerX, double centerY, int radius, ConfigPanel.ShapeType shapeType) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.shapeType = shapeType;
    }

    public DrawShape(double centerX, double centerY, int radius, int nrSides, ConfigPanel.ShapeType shapeType, double[] coordX, double[] coordY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.nrSides = nrSides;
        this.shapeType = shapeType;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    public int getNrSides() {
        return nrSides;
    }

    public ConfigPanel.ShapeType getShapeType() {
        return shapeType;
    }

    public double[] getCoordX() {
        return coordX;
    }

    public double[] getCoordY() {
        return coordY;
    }
}
