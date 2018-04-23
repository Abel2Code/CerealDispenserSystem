package application;

import back_end.*;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try{
			//First read the data base
			DataReader.readData(DataReader.cerealDataBase);
			StartUpScreen start = new StartUpScreen();
			MainMenu mainMenu = new MainMenu();
			Settings settingMenu = new Settings();
			CerealPortions cerealPortions = new CerealPortions();
			

			Scene mainScene = new Scene(start, 800,480);
			mainScene.getStylesheets().add(start.getClass().getResource("styling/StartUpScreen.css").toExternalForm());
			mainScene.getStylesheets().add(mainMenu.getClass().getResource("styling/MainMenu.css").toExternalForm());
			mainScene.getStylesheets().add(settingMenu.getClass().getResource("styling/Settings.css").toExternalForm());

			start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
			mainMenu.getSettingMenu().setOnAction(e -> mainScene.setRoot(settingMenu));
			settingMenu.getSettingToMain().setOnAction(e -> mainScene.setRoot(mainMenu));
			cerealPortions.getBackButton().setOnAction(e -> mainScene.setRoot(mainMenu));
			
			primaryStage.setScene(mainScene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

