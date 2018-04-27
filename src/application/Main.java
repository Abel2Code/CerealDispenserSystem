package application;

import back_end.*;
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
			DataReader.readData(DataReader.milkDataBase);

			StartUpScreen start = new StartUpScreen();
			MainMenu mainMenu = new MainMenu();
			MilkMenu milkMenu = new MilkMenu();
			Container container = new Container();
			OrderHistory orderHistory = new OrderHistory();
			Choice choice = new Choice();
			CerealListFx cerealList = new CerealListFx();
			MilkListFx milkList = new MilkListFx();
			Portions portions = new Portions();
			PourFx pourFx = new PourFx();
			OrderHistoryFx orderHistoryFx = new OrderHistoryFx();
			Button[] cerealButtons = mainMenu.getButtonContainer();
			Button[] milkButtons = milkMenu.getButtonContainer();

			Scene mainScene = new Scene(start, 800,480);
			mainScene.getStylesheets().add(getClass().getResource("styling/application.css").toExternalForm());

			startScreenController(mainMenu, mainScene, start);
			mainMenuController(mainMenu,mainScene,start, cerealList, orderHistoryFx);
			milkMenuController(milkMenu, mainScene, mainMenu, milkList, orderHistoryFx);
			//addFXController(mainMenu, mainScene, cerealList, milkList, addFX);
			cerealListFXController(mainMenu, mainScene, cerealList);
			milkListFXController(milkMenu, mainScene, milkList);
			cerealButtonController(milkMenu, mainScene, cerealButtons);
			milkButtonController(portions, mainScene, milkButtons);
			portionsController(mainMenu, mainScene, pourFx, portions);

			pourFx.getPourButton().setOnAction(e -> {
				OrderHistory.addOrder(Choice.cerealChoice, Choice.milkChoice, Choice.portionChoice);
				System.out.println(orderHistory.toString());
				orderHistoryFx.updateHistory();

				Choice.clearChoice();
				mainScene.setRoot(start);


			});

			pourFx.getBackButton().setOnAction(e -> {
				mainScene.setRoot(portions);
			});

			orderHistoryFx.getBackButton().setOnAction(e -> mainScene.setRoot(mainMenu));
			
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

	public void mainMenuController(MainMenu mainMenu, Scene mainScene, StartUpScreen start, CerealListFx cerealList, OrderHistoryFx orderHistoryFx){
		mainMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(start));
		mainMenu.getAdd().setOnAction(e -> mainScene.setRoot(cerealList));
		mainMenu.getOrderHistory().setOnAction(e -> mainScene.setRoot(orderHistoryFx));
	}

	public void milkMenuController(MilkMenu milkMenu, Scene mainScene, MainMenu mainMenu, MilkListFx milkList, OrderHistoryFx orderHistoryFx) {
		milkMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(mainMenu));
		milkMenu.getAdd().setOnAction(e -> mainScene.setRoot(milkList));
		milkMenu.getOrderHistory().setOnAction(e -> mainScene.setRoot(orderHistoryFx));

	}

	public void startScreenController(MainMenu mainMenu, Scene mainScene, StartUpScreen start){
		start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
	}

	/*public void addFXController(MainMenu mainMenu, Scene mainScene, CerealListFx cerealList, MilkListFx milkList, AddFX addFX){
		addFX.getMainMenu().setOnAction(e -> mainScene.setRoot(mainMenu));
		addFX.getAddCereal().setOnAction(e -> mainScene.setRoot(cerealList));
		addFX.getAddMilk().setOnAction(e -> mainScene.setRoot(milkList));
	}*/

	public void cerealListFXController(MainMenu mainMenu, Scene mainScene, CerealListFx cerealList){
		cerealList.getToMain().setOnAction(e -> mainScene.setRoot(mainMenu));
		cerealList.getSelectButton().setOnAction(e -> {

			Container.addCereal(CerealListFx.selectedCereal);
			mainMenu.refreshFx();
			mainScene.setRoot(mainMenu);

		});
	}

	public void milkListFXController(MilkMenu milkMenu, Scene mainScene, MilkListFx milkList){
		milkList.getToMain().setOnAction(e -> mainScene.setRoot(milkMenu));
		milkList.getSelectButton().setOnAction(e -> {
			milkList.setExpirationDate();
		});

		milkList.getAddMilkButton().setOnAction(e -> {
			Container.addMilk(MilkListFx.selectedMilk, milkList.getExpDate().getText());
			milkList.setCenter(milkList.scroll(milkList.gridOfMilk(Container.milks)));
			milkMenu.refreshFx();
			mainScene.setRoot(milkMenu);

		});

	}

	public void portionsController(MainMenu mainMenu, Scene mainScene, PourFx pourFx, Portions portions) {
		portions.getBackButton().setOnAction(e -> mainScene.setRoot(mainMenu));

		Button[] portionButtons = portions.getPortionButtons();

		portionButtons[0].setOnAction(e -> {
			Choice.setPortionChoice(0);
			mainScene.setRoot(pourFx);
		});

		portionButtons[1].setOnAction(e -> {
			Choice.setPortionChoice(1);
			mainScene.setRoot(pourFx);
		});

		portionButtons[2].setOnAction(e -> {
			Choice.setPortionChoice(2);
			mainScene.setRoot(pourFx);
		});

	}


	public void cerealButtonController(MilkMenu milkMenu, Scene mainScene, Button[] cerealButtons) {
		cerealButtons[0].setOnAction(e -> {
			if (Container.cerealContainer[0] != null) {
				Choice.setCerealChoice(0);
				mainScene.setRoot(milkMenu);
			}
		});

		cerealButtons[1].setOnAction(e -> {
			if (Container.cerealContainer[1] != null) {
				Choice.setCerealChoice(1);
				mainScene.setRoot(milkMenu);
			}
		});

		cerealButtons[2].setOnAction(e -> {
			if (Container.cerealContainer[2] != null) {
				Choice.setCerealChoice(2);
				mainScene.setRoot(milkMenu);
			}
		});

		cerealButtons[3].setOnAction(e -> {
			if (Container.cerealContainer[3] != null) {
				Choice.setCerealChoice(3);
				mainScene.setRoot(milkMenu);
			}
		});

	}

	public void milkButtonController(Portions portions, Scene mainScene, Button[] milkButons) {
		milkButons[0].setOnAction(e -> {
			if (Container.milkContainer[0] != null) {
				Choice.setMilkChoice(0);
				mainScene.setRoot(portions);
			}
		});

		milkButons[1].setOnAction(e -> {
			if (Container.milkContainer[1] != null) {
				Choice.setMilkChoice(1);
				mainScene.setRoot(portions);
			}
		});
	}
}

