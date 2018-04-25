package application;

import back_end.Container;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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

			getChildren().add(iv);

			top();
			container();
			menu();
		}

		public void menu(){
			HBox hbox = new HBox();

			add = new Button("Add");
			add.setId("add");

			Button remove = new Button("Remove");
			remove.setId("remove");

			Button orderHistory = new Button("Order History");
			orderHistory.setId("button");

			Button storageContainer = new Button("Storage View");
			storageContainer.setId("button");

			Button refill = new Button("Replenish Storage");
			refill.setId("button");

			hbox.setPadding(new Insets(18.0,0,10.0,14.0));
			hbox.setSpacing(15.0);
			hbox.getChildren().addAll(add, remove, orderHistory, refill, storageContainer);

			setBottom(hbox);
		}

		public void top(){
			HBox hbox = new HBox();
			toStartScreen = new Button("[Back]");
			toStartScreen.setId("back");

			Text label = new Text("Cereal Dispenser System");
			label.setId("title");

			Button notifications = new Button("!");
			notifications.setId("notifications");

			hbox.setSpacing(50.0);
			hbox.setPadding(new Insets(30.0, 0, 0,0));

			hbox.getChildren().addAll(toStartScreen, label, notifications);
			setTop(hbox);
		}

		public void container(){
			HBox hbox = new HBox();

			for(int i = 0; i < 4; i++) {
				Button addFavorites = new Button();
				addFavorites.setId("favorites");

				if(Container.cerealContainer[i] != null){
					Image img = new Image(Container.cerealContainer[i].getImage());
					ImageView iv = new ImageView(img);
					iv.setFitWidth(addFavorites.getWidth() - 100);
					iv.setFitHeight(addFavorites.getHeight());

					addFavorites.setGraphic(iv);
				}
				else{
					addFavorites.setText("Empty");
				}

				this.cerealContainer = new Button[4];
				this.cerealContainer[i] = addFavorites;
				hbox.getChildren().add(addFavorites);

			}
			hbox.setSpacing(10.0);
			hbox.setPadding(new Insets(30.0, 10.0, 0,30.0));
			setCenter(hbox);


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
