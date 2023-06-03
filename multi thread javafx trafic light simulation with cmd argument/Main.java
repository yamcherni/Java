/**
 * @Author Yam Chernichovski
 * @Version 1
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class Main extends Application{

        public void start(Stage stage) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("lights.fxml"));
                Parent root = (Parent) loader.load();
                LightsController controller = loader.<LightsController>getController(); //get the controller
                 Parameters params = getParameters();   //get args
                 List<String> list = params.getRaw();   //set args in list
                controller.initData(list.get(0));       //set args to controller
                Scene scene = new Scene(root);
                stage.setTitle("tl");
                stage.setScene(scene);
                stage.show();

        }



    public static void main(String[] args) throws IOException {
        launch(args);
        System.out.println();
    }
}
