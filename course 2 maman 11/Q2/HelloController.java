package mmn.q2.mmn11;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    Button b1,b2,b3,b4,b5;

    public void hendleb1() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("2006.fxml"));
        Stage window = (Stage) b1.getScene().getWindow();
        window.setScene(new Scene(root, 500, 500));
    }
    public void hendleb2() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("2007.fxml"));
        Stage window = (Stage) b2.getScene().getWindow();
        window.setScene(new Scene(root, 500, 500));
    }
    public void hendleb3() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("2008.fxml"));
        Stage window = (Stage) b3.getScene().getWindow();
        window.setScene(new Scene(root, 500, 500));
    }
    public void hendleb4() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("2009.fxml"));
        Stage window = (Stage) b4.getScene().getWindow();
        window.setScene(new Scene(root, 500, 500));
    }
    public void hendleb5() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("2005.fxml"));
        Stage window = (Stage) b5.getScene().getWindow();
        window.setScene(new Scene(root, 500, 500));
    }
}