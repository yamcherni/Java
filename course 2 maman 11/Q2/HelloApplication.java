package mmn.q2.mmn11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
        public void start (Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource( "2005.fxml"));
            primaryStage.setTitle("Temperature graph");
            primaryStage.setScene (new Scene (root,  500,  500));
            primaryStage.show();
        }
        public static void main(String[] args) { launch(args); }

    }


