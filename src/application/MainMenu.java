package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MainMenu extends StackPane{
	
	public MainMenu() {
		Image img = new Image("cerealWallpaper.jpg");
		ImageView iv = new ImageView(img);
		Button setting = new Button("?");
		setting.setShape(new Circle(700.0));
		setting.setId("setting");
		setAlignment(setting, Pos.BOTTOM_CENTER);

		HBox hbox = new HBox();
		
		for(int i = 0; i < 4; i++) {
			Button addFavorites = new Button("+");
			addFavorites.setMinSize(400.0, 700.0);
			addFavorites.setId("addFavorites");
			
			hbox.getChildren().add(addFavorites);
			
		}
		hbox.setSpacing(45.0);
		setPadding(new Insets(0,0,20,0));
		
		getChildren().addAll(iv,hbox,setting);
		
		hbox.setPadding(new Insets(200, 80, 0, 80));
		
	}
}
