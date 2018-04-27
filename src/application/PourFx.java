package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PourFx extends BorderPane {
    private Button pourButton;
    private Button backButton;

    public PourFx() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView imgV = new ImageView(img);
        getChildren().add(imgV);

        backButton = new Button("[Back]");
        backButton.setId("back");
        backButton.setPadding(new Insets(35.0, 0, 0,0));

        pourButton = new Button("P O U R");
        pourButton.setId("pourButton");

        setTop(backButton);
        setCenter(pourButton);
    }

    public Button getPourButton() {
        return pourButton;
    }

    public Button getBackButton() { return backButton; }

}
