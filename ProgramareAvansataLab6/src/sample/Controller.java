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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

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

    public Controller() {
        configPanel = new ConfigPanel();
        drawingPanel = new DrawingPanel(configPanel);
        coPane = configPanel;
        drPane = drawingPanel;
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
    protected void handleDrawShape(MouseEvent mouseEvent) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Color color = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        switch(configPanel.getSelectedShape()){
            case CIRCLE:
                int radius =  configPanel.getShapeSize();
                graphicsContext.setFill(color);
                graphicsContext.fillOval(mouseEvent.getX() -  radius, mouseEvent.getY() - radius, radius * 2, radius * 2);
        }
    }

    @FXML
    protected void handleExitButton(ActionEvent event){
        System.exit(0);
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
