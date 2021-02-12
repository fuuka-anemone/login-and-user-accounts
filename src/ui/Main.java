package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private ClassroomGUI cgui;

    public Main(){
        cgui = new ClassroomGUI();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
        loader.setController(cgui);
        primaryStage.setTitle("Classroom");
        primaryStage.setScene(new Scene(loader.load()));
        cgui.loadLogIn(null);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
