package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CerealPortions extends BorderPane {
    private Button backButton;



    public CerealPortions() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView view = new ImageView(img);
        getChildren().addAll(view);
        HBox top = new HBox();
        backButton = new Button("<");
        Label title = new Label("Select Portion");

        top.getChildren().addAll(backButton, title);

        VBox portions = new VBox();

        Button small = new Button("Small");
        Button medium = new Button("Medium");
        Button large = new Button("Large");

        portions.getChildren().addAll(small, medium, large);

        setTop(top);
        setCenter(portions);
    }

    public Button getBackButton() {
        return backButton;
    }

}
