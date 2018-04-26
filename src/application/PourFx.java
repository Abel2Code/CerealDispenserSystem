package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import javax.swing.*;

public class PourFx extends StackPane {
    Button pourButton;

    public PourFx() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView imgV = new ImageView(img);

        pourButton = new Button("P O U R");
        pourButton.setId("pourButton");
        setAlignment(pourButton, Pos.CENTER);

        getChildren().addAll(imgV, pourButton);

    }

    public Button getPourButton() {
        return pourButton;
    }

}
