package application;

import back_end.Container;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MilkMenu extends BorderPane {
    private Button add;
    private Button toStartScreen;
    private Button[] buttonContainer = new Button[2];

    public MilkMenu() {
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

        Button remove = new Button("Remove");
        remove.setId("remove");

        Button orderHistory = new Button("Order History");
        orderHistory.setId("button");

        Button storageContainer = new Button("Storage View");
        storageContainer.setId("button");

        Button refill = new Button("Replenish Storage");
        refill.setId("button");

        hbox.setPadding(new Insets(18.0,0,10.0,14.0));
        hbox.setSpacing(15.0);
        hbox.getChildren().addAll(add, remove, orderHistory, refill, storageContainer);

        setBottom(hbox);
    }

    public void top(){
        HBox hbox = new HBox();
        toStartScreen = new Button("[Back]");
        toStartScreen.setId("back");

        Text label = new Text("Milk Menu");
        label.setId("title");

        Button notifications = new Button("!");
        notifications.setId("notifications");

        hbox.setSpacing(204.0);
        hbox.setPadding(new Insets(30.0, 0, 0,0));

        hbox.getChildren().addAll(toStartScreen, label, notifications);
        setTop(hbox);
    }

    public void container(){
        HBox hbox = new HBox();

        for(int i = 0; i < 2; i++) {
            Button addFavorites = new Button();
            addFavorites.getStyleClass().add("favorites");
            addFavorites.setId("container" + i);

            addFavorites.setText("Empty");

            this.buttonContainer[i] = addFavorites;
            hbox.getChildren().add(addFavorites);

        }
        hbox.setSpacing(10.0);
        hbox.setPadding(new Insets(30.0, 100.0, 0,30.0));
        setCenter(hbox);


    }

    public void refreshFx(){
        for (int i = 0 ; i < buttonContainer.length ; i ++) {
            if(Container.milkContainer[i] != null){
                Image img = new Image(Container.milkContainer[i].getImage());
                ImageView iv = new ImageView(img);
                iv.setFitHeight(250);
                iv.setFitWidth(155);

                buttonContainer[i].setGraphic(iv);
                buttonContainer[i].setText(null);
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



}

