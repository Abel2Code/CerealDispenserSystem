package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AddFX extends BorderPane {
    private Button mainMenu;
    private Button addCereal;
    private Button addMilk;

    public AddFX(){
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView imgV = new ImageView(img);
        getChildren().add(imgV);
        title();
        selection();

    }

    public void title(){
        HBox hbox = new HBox();
        this.mainMenu = new Button("[Back]");
        mainMenu.setTextFill(Color.RED);
        mainMenu.setMinSize(80.0, 50.0);
        mainMenu.setStyle("-fx-background-color: Transparent");
        Text txt = new Text("Select What You Want To Add");
        txt.setFill(Color.valueOf("#1294FF"));
        txt.setFont(Font.font("Helvetica", FontWeight.BOLD, 43.0));

        hbox.getChildren().addAll(mainMenu, txt);
        setTop(hbox);
    }

    public void selection(){
        VBox vbox = new VBox();
        Button[] button = new Button[2];
        this.addCereal = new Button("Cereal");
        this.addMilk = new Button("Milk");
        button[0] = this.addCereal;
        button[1] = this.addMilk;

        for (int i = 0; i < button.length; i++){
            button[i]. setMinSize(500.0, 100.0);
            button[i].setStyle("-fx-background-color: Transparent;-fx-border-color: black; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
            button[i].setFont(Font.font("Helvetica", FontWeight.BOLD, 20.0));
            vbox.getChildren().add(button[i]);
        }
        vbox.setPadding(new Insets(65.0,0.0,0.0,150.0));
        vbox.setSpacing(20.0);
        setCenter(vbox);

    }

    public Button getMainMenu() {
        return mainMenu;
    }

    public Button getAddCereal() {
        return addCereal;
    }

    public Button getAddMilk(){ return addMilk; }
}
