package application;

import back_end.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
			DataReader.readData(DataReader.milkDataBase);
			Container container = new Container();
			StartUpScreen start = new StartUpScreen();
			MainMenu mainMenu = new MainMenu();
			AddFX addFX = new AddFX();
			CerealListFx cerealList = new CerealListFx();
			MilkListFx milkList = new MilkListFx();


			Scene mainScene = new Scene(start, 800,480);
			mainScene.getStylesheets().add(start.getClass().getResource("styling/StartUpScreen.css").toExternalForm());
			mainScene.getStylesheets().add(mainMenu.getClass().getResource("styling/MainMenu.css").toExternalForm());
            startScreenController(mainMenu, mainScene, start);
            mainMenuController(mainMenu,mainScene,start,addFX);
            addFXController(mainMenu, mainScene, cerealList, milkList, addFX);
            cerealListFXController(mainMenu, mainScene, cerealList,addFX);
            milkListFXController(mainMenu, mainScene, milkList,addFX);
//			start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
//			mainMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(start));
//			addFX.getMainMenu().setOnAction(e -> mainScene.setRoot(mainMenu));
//			mainMenu.getAdd().setOnAction(e -> mainScene.setRoot(addFX));
//            addFX.getAddCereal().setOnAction(e -> mainScene.setRoot(cerealList));
//            cerealList.getSelectButton().setOnAction(e -> mainScene.setRoot(mainMenu));
//			cerealList.getToMain().setOnAction(e -> mainScene.setRoot(mainMenu));
//            cerealList.getSelectButton().setOnAction(e -> {
//
//					Container.addCereal(CerealListFx.selectedCereal);
//            		mainMenu.refreshFx();
//					mainScene.setRoot(mainMenu);
//                for(int i = 0; i < Container.cerealContainer.length; i++){
//                    if(Container.cerealContainer[i] == null){
//                        System.out.println("null");
//                    }
//                    else {
//                        System.out.println(Container.cerealContainer[i].getName());
//                    }
//                }
//			});
			
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

	public void mainMenuController(MainMenu mainMenu, Scene mainScene, StartUpScreen start, AddFX addFX){
        mainMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(start));
        mainMenu.getAdd().setOnAction(e -> mainScene.setRoot(addFX));
    }

    public void startScreenController(MainMenu mainMenu, Scene mainScene, StartUpScreen start){
        start.setOnMouseClicked(e -> mainScene.setRoot(mainMenu));
    }

    public void addFXController(MainMenu mainMenu, Scene mainScene, CerealListFx cerealList, MilkListFx milkList, AddFX addFX){
        addFX.getMainMenu().setOnAction(e -> mainScene.setRoot(mainMenu));
        addFX.getAddCereal().setOnAction(e -> mainScene.setRoot(cerealList));
        addFX.getAddMilk().setOnAction(e -> mainScene.setRoot(milkList));
    }

    public void cerealListFXController(MainMenu mainMenu, Scene mainScene, CerealListFx cerealList, AddFX addFX){
        cerealList.getToMain().setOnAction(e -> mainScene.setRoot(addFX));
        cerealList.getSelectButton().setOnAction(e -> {

            Container.addCereal(CerealListFx.selectedCereal);
            mainMenu.refreshFx();
            mainScene.setRoot(mainMenu);

        });
    }

    public void milkListFXController(MainMenu mainMenu, Scene mainScene, MilkListFx milkListFx, AddFX addFX){
	    milkListFx.getToMain().setOnAction(e -> mainScene.setRoot(addFX));
    }
}

