package application;

import back_end.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class Main extends Application {

    @Override
	public void start(Stage primaryStage) {
		try {
			//First read the data base
			DataReader.readData(DataReader.cerealDataBase);
			DataReader.readData(DataReader.milkDataBase);

			StartUpScreen start = new StartUpScreen();
			CerealMenu cerealMenu = new CerealMenu();
			MilkMenu milkMenu = new MilkMenu();
			Container container = new Container();
			OrderHistory orderHistory = new OrderHistory();
			Choice choice = new Choice();
			CerealListFx cerealList = new CerealListFx();
			MilkListFx milkList = new MilkListFx();
			Portions portions = new Portions();
			PourFx pourFx = new PourFx();
			RemoveCerealFx removeCerealFx = new RemoveCerealFx();
			RemoveMilkFx removeMilkFx = new RemoveMilkFx();
			OrderHistoryFx orderHistoryFx = new OrderHistoryFx();
			Button[] cerealButtons = cerealMenu.getButtonContainer();
			Button[] milkButtons = milkMenu.getButtonContainer();

			Scene mainScene = new Scene(start, 800, 480);
			mainScene.getStylesheets().add(getClass().getResource("styling/application.css").toExternalForm());

			startScreenController(cerealMenu, mainScene, start);
			cerealMenuController(cerealMenu, mainScene, start, cerealList, orderHistoryFx, removeCerealFx);
			milkMenuController(milkMenu, mainScene, cerealMenu, milkList, orderHistoryFx, removeMilkFx);
			cerealListFXController(cerealMenu, mainScene, cerealList);
			milkListFXController(milkMenu, mainScene, milkList);
			cerealButtonController(milkMenu, mainScene, cerealButtons);
			milkButtonController(portions, mainScene, milkButtons);
			portionsController(milkMenu, mainScene, pourFx, portions);
			orderHistoryFxController(cerealMenu, mainScene, pourFx, orderHistoryFx, container);
			removeCerealFxController(cerealMenu, mainScene, removeCerealFx);
			removeMilkFxController(milkMenu, mainScene, removeMilkFx);
			pourFxController(pourFx, orderHistory, mainScene, start, portions);

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

	public void startScreenController(CerealMenu cerealMenu, Scene mainScene, StartUpScreen start){
		start.setOnMouseClicked(e -> mainScene.setRoot(cerealMenu));
	}

	public void cerealMenuController(CerealMenu cerealMenu, Scene mainScene, StartUpScreen start, CerealListFx cerealList, OrderHistoryFx orderHistoryFx, RemoveCerealFx removeCerealFx){
		cerealMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(start));
		cerealMenu.getAdd().setOnAction(e -> mainScene.setRoot(cerealList));
		cerealMenu.getOrderHistory().setOnAction(e -> {
			orderHistoryFx.updateHistory();
			mainScene.setRoot(orderHistoryFx);
		});

		cerealMenu.getRemove().setOnAction(e -> {
			removeCerealFx.refreshFx();
			mainScene.setRoot(removeCerealFx);
		});
	}

	public void milkMenuController(MilkMenu milkMenu, Scene mainScene, CerealMenu cerealMenu, MilkListFx milkList, OrderHistoryFx orderHistoryFx, RemoveMilkFx removeMilkFx) {
		milkMenu.getToStartScreen().setOnAction(e -> mainScene.setRoot(cerealMenu));
		milkMenu.getAdd().setOnAction(e -> {

		    milkList.setCenter(milkList.scroll(milkList.gridOfMilk(Container.milks)));
		    mainScene.setRoot(milkList);
        });
		
		milkMenu.getOrderHistory().setOnAction(e -> {
			orderHistoryFx.updateHistory();
			mainScene.setRoot(orderHistoryFx);
		});

		milkMenu.getRemove().setOnAction(e -> {
			removeMilkFx.refreshFx();
			mainScene.setRoot(removeMilkFx);
		});

	}

	public void cerealListFXController(CerealMenu cerealMenu, Scene mainScene, CerealListFx cerealList){
		cerealList.getToMain().setOnAction(e -> mainScene.setRoot(cerealMenu));
		cerealList.getSelectButton().setOnAction(e -> {

			Container.addCereal(CerealListFx.selectedCereal);
			cerealMenu.refreshFx();
			mainScene.setRoot(cerealMenu);

		});
	}

	public void milkListFXController(MilkMenu milkMenu, Scene mainScene, MilkListFx milkList){
		milkList.getToMain().setOnAction(e -> mainScene.setRoot(milkMenu));
		milkList.getSelectButton().setOnAction(e -> {
			milkList.setExpirationDate();
		});

		milkList.getAddMilkButton().setOnAction(e -> {
			Container.addMilk(MilkListFx.selectedMilk, milkList.getExpDate());
			milkList.setCenter(milkList.scroll(milkList.gridOfMilk(Container.milks)));
			milkMenu.refreshFx();
			mainScene.setRoot(milkMenu);

		});

	}


	public void removeCerealFxController(CerealMenu cerealMenu, Scene mainScene, RemoveCerealFx removeCerealFx) {
		removeCerealFx.getToStartScreen().setOnAction(e -> mainScene.setRoot(cerealMenu));

		Button[] buttons = removeCerealFx.getButtonContainer();

		if (buttons[0] != null) {
			buttons[0].setOnAction(e -> {
				Container.delCereal(0);
				cerealMenu.refreshFx();
				mainScene.setRoot(cerealMenu);
			});
		}

		if (buttons[1] != null) {
			buttons[1].setOnAction(e -> {
				Container.delCereal(1);
				cerealMenu.refreshFx();
				mainScene.setRoot(cerealMenu);
			});
		}

		if (buttons[2] != null) {
			buttons[2].setOnAction(e -> {
				Container.delCereal(2);
				cerealMenu.refreshFx();
				mainScene.setRoot(cerealMenu);
			});
		}

		if (buttons[3] != null) {
			buttons[3].setOnAction(e -> {
				Container.delCereal(3);
				cerealMenu.refreshFx();
				mainScene.setRoot(cerealMenu);
			});
		}
		
	}

	public void removeMilkFxController(MilkMenu milkMenu, Scene mainScene, RemoveMilkFx removeMilkFx) {
		removeMilkFx.getToStartScreen().setOnAction(e -> mainScene.setRoot(milkMenu));

		Button[] buttons = removeMilkFx.getButtonContainer();

		if (buttons[0] != null) {
			buttons[0].setOnAction(e -> {
				Container.delMilk(0);
				milkMenu.refreshFx();
				mainScene.setRoot(milkMenu);
			});
		}

		if (buttons[1] != null) {
			buttons[1].setOnAction(e -> {
				Container.delMilk(1);
				milkMenu.refreshFx();
				mainScene.setRoot(milkMenu);
			});
		}
	}



	public void portionsController(MilkMenu milkMenu, Scene mainScene, PourFx pourFx, Portions portions) {
		portions.getBackButton().setOnAction(e -> mainScene.setRoot(milkMenu));

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

	public void milkButtonController(Portions portions, Scene mainScene, Button[] milkButtons) {

    	milkButtons[0].setOnAction(e -> {
			if (Container.milkContainer[0] != null) {
				Choice.setMilkChoice(0);
				mainScene.setRoot(portions);
			}
		});

		milkButtons[1].setOnAction(e -> {
			if (Container.milkContainer[1] != null) {
				Choice.setMilkChoice(1);
				mainScene.setRoot(portions);
			}
		});

		milkButtons[2].setOnAction(event -> {
		    Choice.setMilkChoice(2);
		    mainScene.setRoot(portions);

        });
	}

	public void orderHistoryFxController(CerealMenu cerealMenu, Scene mainScene, PourFx pourFx, OrderHistoryFx orderHistoryFx, Container container) {
		orderHistoryFx.getBackButton().setOnAction(e -> mainScene.setRoot(cerealMenu));
		
		Button[] b = orderHistoryFx.getButtonContainer();

		if (b[0] != null) {
			b[0].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 1).getCereal();
				final Milk m = orders.get(orders.size() - 1).getMilk();
				final int p = orders.get(orders.size() - 1).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[1] != null) {
			b[1].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 2).getCereal();
				final Milk m = orders.get(orders.size() - 2).getMilk();
				final int p = orders.get(orders.size() - 2).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[2] != null) {
			b[2].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 3).getCereal();
				final Milk m = orders.get(orders.size() - 3).getMilk();
				final int p = orders.get(orders.size() - 3).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[3] != null) {
			b[3].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 4).getCereal();
				final Milk m = orders.get(orders.size() - 4).getMilk();
				final int p = orders.get(orders.size() - 4).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[4] != null) {
			b[4].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 5).getCereal();
				final Milk m = orders.get(orders.size() - 5).getMilk();
				final int p = orders.get(orders.size() - 5).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[5] != null) {
			b[5].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 6).getCereal();
				final Milk m = orders.get(orders.size() - 6).getMilk();
				final int p = orders.get(orders.size() - 6).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[6] != null) {
			b[6].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 7).getCereal();
				final Milk m = orders.get(orders.size() - 7).getMilk();
				final int p = orders.get(orders.size() - 7).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[7] != null) {
			b[7].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 8).getCereal();
				final Milk m = orders.get(orders.size() - 8).getMilk();
				final int p = orders.get(orders.size() - 8).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[8] != null) {
			b[8].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 9).getCereal();
				final Milk m = orders.get(orders.size() - 9).getMilk();
				final int p = orders.get(orders.size() - 9).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}

		if (b[9] != null) {
			b[9].setOnAction(e -> {
				final List<Order> orders = OrderHistory.orders;
				final Cereal c = orders.get(orders.size() - 10).getCereal();
				final Milk m = orders.get(orders.size() - 10).getMilk();
				final int p = orders.get(orders.size() - 10).getPortion();

				Choice.setCerealChoice(Container.getCerealIndex(c));
				Choice.setMilkChoice(Container.getMilkIndex(m));
				Choice.setPortionChoice(p);

				mainScene.setRoot(pourFx);
			});
		}
	}

	public void pourFxController(PourFx pourFx, OrderHistory orderHistory, Scene mainScene, StartUpScreen start, Portions portions) {
		pourFx.getPourButton().setOnAction(e -> {
			OrderHistory.addOrder(Choice.cerealChoice, Choice.milkChoice, Choice.portionChoice);
			System.out.println(orderHistory.toString());

			Choice.clearChoice();
			mainScene.setRoot(start);

		});

		pourFx.getBackButton().setOnAction(e -> {
			mainScene.setRoot(portions);
		});
	}

}

