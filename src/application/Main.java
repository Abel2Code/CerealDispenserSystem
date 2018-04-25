package application;

import back_end.Container;
import back_end.DataReader;
import back_end.Order;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
						System.out.println(i);
					}
					else {
						System.out.println(Container.cerealContainer[i].getName());
					}
				}


			});

			Button[] buttonContainer = mainMenu.getButtonContainer();
			System.out.println(Order.getCerealIndex());

			buttonContainer[0].setOnAction(e -> {
				if (Container.cerealContainer[0] != null) {
					Order.setCerealIndex(0);
					mainScene.setRoot(cerealPortions);
				}
			});

			buttonContainer[1].setOnAction(e -> {
				if (Container.cerealContainer[1] != null) {
					Order.setCerealIndex(1);
					mainScene.setRoot(cerealPortions);
				}
			});

			buttonContainer[2].setOnAction(e -> {
				if (Container.cerealContainer[2] != null) {
					Order.setCerealIndex(2);
					mainScene.setRoot(cerealPortions);
				}
			});

			buttonContainer[3].setOnAction(e -> {
				if (Container.cerealContainer[3] != null) {
					Order.setCerealIndex(3);
					mainScene.setRoot(cerealPortions);
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

