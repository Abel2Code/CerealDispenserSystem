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
			
			BorderPane pane = new BorderPane();
			Button r = new Button("hello");
			
			pane.setCenter(r);
			Scene mainScene = new Scene(start);
			mainScene.getStylesheets().add(start.getClass().getResource("StartUpScreen.css").toExternalForm());
			mainScene.getStylesheets().add(mainMenu.getClass().getResource("MainMenu.css").toExternalForm());
			
			start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
			mainMenu.getSettingMenu().setOnAction(e -> mainScene.setRoot(settingMenu));
			
			primaryStage.setScene(mainScene);
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

