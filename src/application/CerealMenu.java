package application;

import back_end.Container;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CerealMenu extends BorderPane {
    private Button add;
    private Button remove;
    private Button toStartScreen;
    private Button orderHistory;
    private Button storageContainer;
    private Button info;
    private Button[] buttonContainer = new Button[4];

    public CerealMenu() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView iv = new ImageView(img);

        getChildren().add(iv);

        top();
        container();
        menu();
    }

    public void menu(){
        HBox hbox = new HBox();

        add = new Button("Add");
        add.setId("add");

        remove = new Button("Remove");
        remove.setId("remove");

        orderHistory = new Button("Order History");
        orderHistory.setId("button");

        storageContainer = new Button("Storage View");
        storageContainer.setId("button");

        Button assistant = new Button("Voice Assistant: ON");
        assistant.setId("button");

        assistant.setOnAction(e -> {
            if(assistant.getText().contains("ON")){
                assistant.setText("Voice Assistant: OFF");
                Speech.isMute = true;
            }
            else if(assistant.getText().contains("OFF")){
                assistant.setText("Voice Assistant: ON");
                Speech.isMute = false;
            }
        });

        hbox.setPadding(new Insets(18.0,0,10.0,14.0));
        hbox.setSpacing(15.0);
        hbox.getChildren().addAll(add, remove, orderHistory, storageContainer, assistant);

        setBottom(hbox);
    }

    public void top(){
        HBox hbox = new HBox();
        toStartScreen = new Button("[Back]");
        toStartScreen.setId("back");

        Text label = new Text("Cereal Menu");
        label.setId("title");

        info = new Button("i");
        info.setId("notifications");

        hbox.setSpacing(180.0);
        hbox.setPadding(new Insets(30.0, 0, 0,0));


        hbox.getChildren().addAll(toStartScreen, label, info);
        setTop(hbox);
    }

    public void container(){
        HBox hbox = new HBox();

        for(int i = 0; i < 4; i++) {
            Button addFavorites = new Button();
            addFavorites.getStyleClass().add("favorites");
            addFavorites.setId("container" + i);

            addFavorites.setText("Empty");

            this.buttonContainer[i] = addFavorites;
            hbox.getChildren().add(addFavorites);

        }
        hbox.setSpacing(10.0);
        hbox.setPadding(new Insets(30.0, 10.0, 0,30.0));
        setCenter(hbox);


    }

    public void refreshFx(){
        for (int i = 0 ; i < buttonContainer.length ; i ++) {
            if(Container.cerealContainer[i] != null){
                Image img = new Image(Container.cerealContainer[i].getImage());
                ImageView iv = new ImageView(img);
                iv.setFitHeight(250);
                iv.setFitWidth(155);

                buttonContainer[i].setGraphic(iv);
                buttonContainer[i].setText(null);
            }
            else {
                buttonContainer[i].setGraphic(null);
                buttonContainer[i].setText("Empty");
            }
        }
    }

    public Button[] getButtonContainer() {
        return buttonContainer;
    }

    public Button getToStartScreen(){
        return toStartScreen;
    }

    public Button getAdd(){
        return add;
    }

    public Button getOrderHistory() {
        return orderHistory;
    }

    public Button getRemove() {
        return remove;
    }

    public Button getStorageContainer() {
        return storageContainer;
    }

    public Button getInfo() {
        return info;
    }






}

