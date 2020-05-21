package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Controller {
    @FXML
    private GridPane designPane;
    @FXML
    private TextField nameLabel;
    @FXML
    private TextField textLabel;
    @FXML
    private Button submitButton;

    String elementName = "javafx.scene.control.Button";
    String elementText = "buton";

    @FXML
    protected void handleSetName(ActionEvent actionEvent){
        TextField textField = (TextField) actionEvent.getSource();
        elementName = textField.getText();
        textField.clear();
    }

    @FXML
    protected void handleSetText(ActionEvent actionEvent){
        TextField textField = (TextField) actionEvent.getSource();
        elementText = textField.getText();
        textField.clear();
    }

    @FXML
    protected void handleCreateElement(ActionEvent event){
        Node node = null;
        Class thisClass = null;
        try {
             thisClass = Class.forName(elementName);
            node = (Node) thisClass.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return;
        }


        designPane.add(node, 0, 0);
        node.setStyle("-fx-pref-width: 200; -fx-pref-height:300");
        Class[] signature = new Class[] {String.class};
        try {
            Method method = thisClass.getMethod("setText", signature);
            method.invoke(node, elementText);
        } catch (NoSuchMethodException e) {
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleCreateClick(ActionEvent event){

    }

}
