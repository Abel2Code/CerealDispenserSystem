package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class StartUpScreen extends StackPane{
	public StartUpScreen() {
		Image image = new Image("wallpapers/cerealWallpaper.jpg");
		ImageView view = new ImageView(image);
		Label label = new Label();
		label.setGraphic(view);
		label.setMinWidth(800.0);
		label.setMinHeight(480.0);
	    Text touchBegin = new Text("Touch to Begin");
	    touchBegin.setId("touchToBegin");
	    getChildren().addAll(label, touchBegin);
	    
	    setAlignment(Pos.CENTER);
	    
	    
	}
	
}
