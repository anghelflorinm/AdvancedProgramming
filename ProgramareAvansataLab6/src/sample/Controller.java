package sample;

import com.sun.prism.Graphics;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Controller {

    @FXML
    private ConfigPanel configPanel;

    @FXML
    private Pane coPane;
    @FXML
    private DrawingPanel drawingPanel;
    @FXML
    private Pane drPane;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Canvas canvas;

    private List<DrawShape> shapeList;

    public Controller() {
        configPanel = new ConfigPanel();
        drawingPanel = new DrawingPanel(configPanel);
        coPane = configPanel;
        drPane = drawingPanel;
        shapeList = new LinkedList<>();
    }

    @FXML
    protected void handleSetSizeTextField(ActionEvent event) {
        TextField textField = (TextField) event.getSource();
        try {
            int size = Integer.parseInt(textField.getText());
            configPanel.setShapeSize(size);
            textField.clear();
        } catch (NumberFormatException e) {
            textField.setText("Not a number! Try again!");
        }
    }

    @FXML
    protected void setRed(ActionEvent event){
        switch (configPanel.getFillType()){
            case SHAPE:
                configPanel.setColorTypeFill(ConfigPanel.ColorType.RED);
                break;
            case STROKE:
                configPanel.setColorTypeStroke(ConfigPanel.ColorType.RED);
        }
    }

    @FXML
    protected void setSidesConfig(ActionEvent event){
        TextField textField = (TextField) event.getSource();
        try {
            int nrSides = Integer.parseInt(textField.getText());
            configPanel.setNrOfSides(nrSides);
            textField.clear();
        } catch (NumberFormatException e) {
            textField.setText("Not a number! Try again!");
        }
    }

    @FXML
    protected void setBlue(ActionEvent event){
        switch (configPanel.getFillType()){
            case SHAPE:
                configPanel.setColorTypeFill(ConfigPanel.ColorType.BLUE);
                break;
            case STROKE:
                configPanel.setColorTypeStroke(ConfigPanel.ColorType.BLUE);
        }
    }

    @FXML
    protected void setGreen(ActionEvent event){
        switch (configPanel.getFillType()){
            case SHAPE:
                configPanel.setColorTypeFill(ConfigPanel.ColorType.GREEN);
                break;
            case STROKE:
                configPanel.setColorTypeStroke(ConfigPanel.ColorType.GREEN);
        }
    }

    @FXML
    protected void setRandom(ActionEvent event){
        switch (configPanel.getFillType()){
            case SHAPE:
                configPanel.setColorTypeFill(ConfigPanel.ColorType.RANDOM);
                break;
            case STROKE:
                configPanel.setColorTypeStroke(ConfigPanel.ColorType.RANDOM);
        }
    }

    @FXML
    protected void setCircle(ActionEvent event){
        configPanel.setSelectedShape(ConfigPanel.ShapeType.CIRCLE);
    }

    @FXML
    protected void setPolygon(ActionEvent event){
        configPanel.setSelectedShape(ConfigPanel.ShapeType.POLYGON);
    }

    @FXML
    protected void setFillConfig(ActionEvent event){
        configPanel.setFillType(ConfigPanel.FillType.SHAPE);
    }

    @FXML
    protected void setStrokeConfig(ActionEvent event){
        configPanel.setFillType(ConfigPanel.FillType.STROKE);
    }

    void calculatePolygonPoints(double[] coordX, double[] coordY, double centerX, double centerY, int nrSides, int radius){
        double angleStep = Math.PI * 2 / nrSides;
        double angle = 0;
        for(int i = 0; i<nrSides; i++, angle += angleStep){
            coordX[i] = Math.sin(angle) * radius + centerX;
            coordY[(i+1)%nrSides] = Math.sin(angle) * radius + centerY;
        }
    }

    private void deleteShape(double clickX, double clickY){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Color colorFill =  Color.web("#E69A8DFF");
        graphicsContext.setFill(colorFill);
        graphicsContext.setStroke(colorFill);
        for(int i = 0; i<shapeList.size(); i++){
            int radius = shapeList.get(i).getRadius();
            graphicsContext.setLineWidth(radius * 0.6);
            double centerX = shapeList.get(i).getCenterX();
            double centerY = shapeList.get(i).getCenterY();
            if(clickX>=centerX - radius && clickX <= centerX + radius  && clickY>=centerY - radius && clickY <= centerY + radius){
                switch (shapeList.get(i).getShapeType()){
                    case CIRCLE:
                        graphicsContext.fillOval(centerX - radius, centerY - radius, radius*2, radius*2);
                        graphicsContext.strokeOval(centerX - radius, centerY - radius, radius*2, radius*2);
                        break;
                    case POLYGON:
                        graphicsContext.fillPolygon(shapeList.get(i).getCoordX(), shapeList.get(i).getCoordY(), shapeList.get(i).getNrSides());
                        graphicsContext.strokePolygon(shapeList.get(i).getCoordX(), shapeList.get(i).getCoordY(), shapeList.get(i).getNrSides());
                }
            }
        }
    }

    @FXML
    protected void handleDrawShape(MouseEvent mouseEvent) {

        if(configPanel.getClickType() == ConfigPanel.ClickType.DELETE){
            deleteShape(mouseEvent.getX(), mouseEvent.getY());
            return;
        }
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Color colorFill = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        Color colorStroke = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        switch (configPanel.getColorTypeFill()){
            case RED:
                colorFill = Color.RED;
                break;
            case BLUE:
                colorFill = Color.BLUE;
                break;
            case GREEN:
                colorFill = Color.GREEN;
                break;
            case RANDOM:
                colorFill = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));

        }

        switch (configPanel.getColorTypeFill()){
            case RED:
                colorStroke = Color.RED;
                break;
            case BLUE:
                colorStroke = Color.BLUE;
                break;
            case GREEN:
                colorStroke = Color.GREEN;
                break;
            case RANDOM:
                colorStroke = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));

        }
        graphicsContext.setFill(colorFill);
        graphicsContext.setStroke(colorStroke);

        int size =  configPanel.getShapeSize();
        graphicsContext.setLineWidth(size * 0.5);
        switch(configPanel.getSelectedShape()){
            case CIRCLE:

                graphicsContext.fillOval(mouseEvent.getX() -  size, mouseEvent.getY() - size, size * 2, size * 2);
                graphicsContext.strokeOval(mouseEvent.getX() -  size, mouseEvent.getY() - size, size * 2, size * 2);
                shapeList.add(new DrawShape(mouseEvent.getX(), mouseEvent.getY(), size, ConfigPanel.ShapeType.CIRCLE));
                break;
            case POLYGON:
                int nrSides = configPanel.getNrOfSides();
                double [] coordX = new double[nrSides];
                double [] coordY = new double[nrSides];
                calculatePolygonPoints(coordX, coordY, mouseEvent.getX(), mouseEvent.getY(), nrSides, size * 2);
                graphicsContext.fillPolygon(coordX, coordY, nrSides);
                graphicsContext.strokePolygon(coordX, coordY, nrSides);
                shapeList.add(new DrawShape(mouseEvent.getX(), mouseEvent.getY(), size  * 2, nrSides, ConfigPanel.ShapeType.POLYGON, coordX, coordY));
        }
    }

    @FXML
    protected void handleExitButton(ActionEvent event){
        System.exit(0);
    }

    @FXML
    protected void setDrawConfig(ActionEvent event){
        configPanel.setClickType(ConfigPanel.ClickType.DRAW);
    }

    @FXML
    protected void setDeleteConfig(ActionEvent event){
        configPanel.setClickType(ConfigPanel.ClickType.DELETE);
    }

    @FXML
    protected void handleResetButton(ActionEvent event){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    protected void handleSaveButton(ActionEvent event){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(anchorPane.getScene().getWindow());

        if(file != null){
            try {
                WritableImage writableImage = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                System.out.println("Could not write to file!");
            }
        }
    }

    @FXML
    protected void handleLoadButton(ActionEvent event){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(anchorPane.getScene().getWindow());

        try {
            Image image = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            graphicsContext.drawImage(image, 0, 0);
        } catch (IOException e) {
            System.out.println("Could not write to file!");
        }

    }
}
