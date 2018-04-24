package application;

import back_end.Container;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu extends BorderPane {
		private Button settingMenu;
		private Button add;
		private Button toStartScreen;
		private Button[] cerealContainer;

	public MainMenu() {
			Image img = new Image("wallpapers/woodWallpaper.jpg");
			ImageView iv = new ImageView(img);
			this.settingMenu = new Button("?");
			settingMenu.setShape(new Circle(700.0));
			settingMenu.setId("setting");

			getChildren().addAll(settingMenu, iv);
//
//			hbox.setPadding(new Insets(200, 80, 0, 80));
			top();
			container();
			menu();
		}

		public void menu(){
			HBox hbox = new HBox();

			add = new Button("Add");
			buttonMinSize(add);
			add.setStyle("-fx-background-color: Transparent; -fx-border-color: Green; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
			add.setFont(Font.font("Helvetica", FontWeight.BOLD, 18.0));

			Button remove = new Button("Remove");
			remove.setStyle("-fx-background-color: Transparent; -fx-border-color: red; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
			buttonMinSize(remove);
			remove.setFont(Font.font("Helvetica", FontWeight.BOLD, 18.0));

			Button orderHistory = new Button("Order History");
			orderHistory.setStyle("-fx-background-color: Transparent; -fx-border-color: black; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
			buttonMinSize(orderHistory);
			orderHistory.setFont(Font.font("Helvetica", FontWeight.BOLD, 18.0));

			Button storageContainer = new Button("Storage View");
			storageContainer.setStyle("-fx-background-color: Transparent; -fx-border-color: black; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
			buttonMinSize(storageContainer);
			storageContainer.setFont(Font.font("Helvetica", FontWeight.BOLD, 18.0));

			Button refill = new Button("Replenish Storage");
			refill.setStyle("-fx-background-color: Transparent; -fx-border-color: black; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
			buttonMinSize(refill);
			refill.setFont(Font.font("Helvetica", FontWeight.BOLD, 18.0));

			hbox.setPadding(new Insets(18.0,0,10.0,14.0));
			hbox.setSpacing(15.0);
			hbox.getChildren().addAll(add, remove, orderHistory, refill, storageContainer);

			setBottom(hbox);
		}
		public void top(){
			HBox hbox = new HBox();
			toStartScreen = new Button("[Back]");
			toStartScreen.setTextFill(Color.RED);
			toStartScreen.setMinSize(80.0, 50.0);
			toStartScreen.setStyle("-fx-background-color: Transparent");
			Text label = new Text("Cereal Dispenser System");
			label.setFill(Color.valueOf("#1294FF"));
			label.setFont(Font.font("Helvetica", FontWeight.BOLD, 43.0));
			Button notifications = new Button("!");
			notifications.setStyle("-fx-background-color: Transparent");
			notifications.setFont(Font.font("Helvetica", FontWeight.BOLD, 30.0));
			notifications.setMinSize(80.0, 50.0);

			hbox.setSpacing(80.0);

			hbox.getChildren().addAll(toStartScreen, label, notifications);
			setTop(hbox);
		}

		public void container(){
			HBox hbox = new HBox();

			for(int i = 0; i < 4; i++) {
				Button addFavorites = new Button();
				if(Container.cerealContainer[i] != null){
					ImageView img = new ImageView(new Image(Container.cerealContainer[i].getImage()));

					addFavorites.setGraphic(img);
				}
				else{
					addFavorites.setText("Empty");
				}
				String addCSS = "-fx-border-color: #1294FF;";
				addCSS += "-fx-border-radius: 30.0;";
				addCSS += "-fx-border-width: 4.0;";
				addCSS += "-fx-background-color: Transparent;";
				addCSS += "-fx-background-size: Cover";
				addFavorites.setStyle(addCSS);
				addFavorites.setMinSize(175.0, 300.0);
				this.cerealContainer = new Button[4];
				this.cerealContainer[i] = addFavorites;
				hbox.getChildren().add(addFavorites);

			}
			hbox.setSpacing(10.0);
			hbox.setPadding(new Insets(30.0, 10.0, 0,30.0));
			setCenter(hbox);


		}

		public Button getSettingMenu() {
			return settingMenu;
		}

		public Button[] getCerealContainer(){
			return cerealContainer;
		}

		public Button getToStartScreen(){
			return toStartScreen;
		}

		public Button getAdd(){
			return add;
		}

		public void refreshFx(){
			container();
		}

		public void buttonMinSize(Button b){
			b.setMinSize(125.0, 0);
		}
	
}
