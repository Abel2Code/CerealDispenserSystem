package application;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class StartUpScreen extends StackPane {

    public StartUpScreen() {
        Image image = new Image("resources/wallpapers/cerealWallpaper.jpg");
        ImageView view = new ImageView(image);
        Text touchBegin = new Text("Touch to Begin");
        touchBegin.setId("touchToBegin");
        getChildren().addAll(view, touchBegin);

        setAlignment(Pos.CENTER);

    }

}
