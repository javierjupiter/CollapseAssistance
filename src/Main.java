import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("DiasLaborales.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("incidencias.fxml"));
        primaryStage.setTitle("Collapse Assitance");
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("/images/Collapse_icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, 1000, 613.28));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
