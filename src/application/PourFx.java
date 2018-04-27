package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PourFx extends StackPane {
    private Button pourButton;
    private Button backButton;

    public PourFx() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView imgV = new ImageView(img);

        backButton = new Button("[bakc]");
        backButton.setId("back");
        setAlignment(backButton, Pos.TOP_LEFT);

        pourButton = new Button("P O U R");
        pourButton.setId("pourButton");
        setAlignment(pourButton, Pos.CENTER);

        getChildren().addAll(imgV, pourButton);

    }

    public Button getPourButton() {
        return pourButton;
    }

    public Button getBackButton() { return backButton; }

}
