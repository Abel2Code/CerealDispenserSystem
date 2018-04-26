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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Portions extends BorderPane {
    private Button backButton;
    private Button[] portionbuttons = new Button[3];

    public Portions() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView view = new ImageView(img);

        backButton = new Button("[Back]");
        backButton.setId("back");

        Text title = new Text("Select Portion For Order");
        title.setId("title");

        HBox top = new HBox();
        top.getChildren().addAll(backButton, title);
        top.setSpacing(50.0);
        top.setPadding(new Insets(30.0, 0, 0,0));

        Button small = new Button("Small");
        small.setId("portionButton");

        Button medium = new Button("Medium");
        medium.setId("portionButton");

        Button large = new Button("Large");
        large.setId("portionButton");

        portionbuttons[0] = small;
        portionbuttons[1] = medium;
        portionbuttons[2] = large;

        VBox portions = new VBox();
        portions.setAlignment(Pos.CENTER);
        portions.getChildren().addAll(small, medium, large);
        portions.setSpacing(20.0);


        getChildren().add(view);
        setTop(top);
        setCenter(portions);
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button[] getPortionButtons() { return portionbuttons; }

}
