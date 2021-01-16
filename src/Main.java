import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner leer = new Scanner(System.in);
        Parent root;
        if (true){
            root = FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
        }else {
             root = FXMLLoader.load(getClass().getResource("Asistencia_registro.fxml"));
        }


        primaryStage.setTitle("Collapse Assitance");
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("/images/Collapse_icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, 1000, 613.28));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("Hola mundo de la clase MAIN");
        launch(args);
    }
}
