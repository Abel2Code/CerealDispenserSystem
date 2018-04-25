package application;

import back_end.Container;
import back_end.DataReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try{
			//First read the data base
			DataReader.readData(DataReader.cerealDataBase);
			StartUpScreen start = new StartUpScreen();
			Container container = new Container();
			MainMenu mainMenu = new MainMenu();
			AddFX addFX = new AddFX();
			CerealListFx cerealList = new CerealListFx();
			CerealPortions cerealPortions = new CerealPortions();
			PourFx pourFx = new PourFx();



			Scene mainScene = new Scene(start, 800,480);
			mainScene.getStylesheets().add(getClass().getResource("styling/application.css").toExternalForm());

			start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
			mainMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(start));
			addFX.getMainMenu().setOnAction(e -> mainScene.setRoot(mainMenu));
			mainMenu.getAdd().setOnAction(e -> mainScene.setRoot(addFX));
			addFX.getAddCereal().setOnAction(e -> mainScene.setRoot(cerealList));

			cerealList.getToMain().setOnAction(e -> mainScene.setRoot(mainMenu));
			cerealList.getSelectButton().setOnAction(e -> {

				Container.addCereal(CerealListFx.selectedCereal);
				mainMenu.refreshFx();
				mainScene.setRoot(mainMenu);
				for(int i = 0; i < Container.cerealContainer.length; i++){
					if(Container.cerealContainer[i] == null){
						System.out.println("null");
					}
					else {
						System.out.println(Container.cerealContainer[i].getName());
					}
				}
			});

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

