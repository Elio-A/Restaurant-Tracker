package project.g7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static final View view = new View();
    public static final Model model = new Model();
    public static final Controller controller = new Controller();

    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(view, 800, 400);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        model.startCustomerScreen();
    }

    public static void main(String[] args) { launch(args); }
}
