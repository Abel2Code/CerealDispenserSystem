package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu extends BorderPane{
	private Button settingMenu;
	private Button[] cerealContainer;
	
	public MainMenu() {
		Image img = new Image("wallpapers/woodWallpaper.jpg");
		ImageView iv = new ImageView(img);
		this.settingMenu = new Button("?");
		settingMenu.setShape(new Circle(700.0));
		settingMenu.setId("setting");
//		setAlignment(settingMenu, Pos.BOTTOM_CENTER);
//
//		HBox hbox = new HBox();
//
//		for(int i = 0; i < 4; i++) {
//			Button addFavorites = new Button("+");
//			//addFavorites.setMinSize(400.0, 700.0);
//			addFavorites.setId("addFavorites");
//			this.cerealContainer = new Button[4];
//			this.cerealContainer[i] = addFavorites;
////		hbox.getChildren().add(addFavorites);
//
//		}
//		hbox.setSpacing(45.0);
//		setPadding(new Insets(0,0,20,0));
//
		getChildren().addAll(settingMenu, iv);
//
//		hbox.setPadding(new Insets(200, 80, 0, 80));
        top();
        container();
		menu();
	}

	public void menu(){
	    HBox hbox = new HBox();
	    Button addRemove = new Button("Add/Remove");
	    Button orderHistory = new Button("Order History");
	    Button storageContainer = new Button("Storage View");
	    Button refill = new Button("Replenish Storage");

	    hbox.getChildren().addAll(addRemove, orderHistory, storageContainer, refill);

	    setBottom(hbox);
    }
    public void top(){
	    HBox hbox = new HBox();
	   Button back = new Button("Back");
	   back.setMinSize(80.0, 50.0);
	   Text label = new Text("Cereal Dispenser System");
	   label.setFill(Color.NAVY);
	   label.setFont(Font.font("Helvetica", FontWeight.BOLD, 43.0));
	   Button notifications = new Button("!");
	   notifications.setFont(Font.font("Helvetica", FontWeight.BOLD, 30.0));
	   notifications.setMinSize(80.0, 50.0);

	   hbox.setSpacing(80.0);

	   hbox.getChildren().addAll(back, label, notifications);
	   setTop(hbox);
    }

    public void container(){
	    HBox hbox = new HBox();

		for(int i = 0; i < 4; i++) {
			Button addFavorites = new Button("Empty");
			addFavorites.setMinSize(175.0, 300.0);
			this.cerealContainer = new Button[4];
			this.cerealContainer[i] = addFavorites;
    		hbox.getChildren().add(addFavorites);

		}
		hbox.setSpacing(10.0);
		hbox.setPadding(new Insets(45.0, 10.0, 10.0,30.0));
		setCenter(hbox);


    }

	public Button getSettingMenu() {
		return settingMenu;
	}

	public Button[] getCerealContainer(){
		return cerealContainer;
	}
	
	
}
