package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

