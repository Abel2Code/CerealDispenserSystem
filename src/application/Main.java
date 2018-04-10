package application;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            StartUpScreen start = new StartUpScreen();
            MainMenu mainMenu = new MainMenu();
            Settings settingMenu = new Settings();

            Scene mainScene = new Scene(start);
            mainScene.getStylesheets().add(start.getClass().getResource("styling/StartUpScreen.css").toExternalForm());
            mainScene.getStylesheets().add(mainMenu.getClass().getResource("styling/MainMenu.css").toExternalForm());
            mainScene.getStylesheets().add(settingMenu.getClass().getResource("styling/Settings.css").toExternalForm());

            start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
            mainMenu.getSettingMenu().setOnAction(e -> mainScene.setRoot(settingMenu));

            primaryStage.setScene(mainScene);
            primaryStage.setFullScreen(true);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}
