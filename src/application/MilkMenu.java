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
    private Button remove;
    private Button toStartScreen;
    private Button orderHistory;
    private Button info;
    private Button storageContainer;
    private Button[] buttonContainer = new Button[3];

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

        remove = new Button("Remove");
        remove.setId("remove");

        orderHistory = new Button("Order History");
        orderHistory.setId("button");

        storageContainer = new Button("Storage View");
        storageContainer.setId("button");

        hbox.setPadding(new Insets(18.0,0,10.0,14.0));
        hbox.setSpacing(15.0);
        hbox.getChildren().addAll(add, remove, orderHistory, storageContainer);

        setBottom(hbox);
    }

    public void top(){
        HBox hbox = new HBox();
        toStartScreen = new Button("[Back]");
        toStartScreen.setId("back");

        Text label = new Text("Milk Menu");
        label.setId("title");

        info = new Button("i");
        info.setId("notifications");

        hbox.setSpacing(204.0);
        hbox.setPadding(new Insets(30.0, 0, 0,0));

        hbox.getChildren().addAll(toStartScreen, label, info);
        setTop(hbox);
    }

    public void container(){
        HBox hbox = new HBox();

        for(int i = 0; i < 2; i++) {
            buttonContainer[i] = new Button("Empty");
            buttonContainer[i].getStyleClass().add("favorites");
            buttonContainer[i].setId("container" + (i + 2));

            hbox.getChildren().add(buttonContainer[i]);
        }

        Button noMilk = new Button();
        noMilk.getStyleClass().add("favorites");
        noMilk.setId("container1");
        Image img = new Image("milk/noMilk.png");
        ImageView iv = new ImageView(img);
        iv.setFitHeight(250);
        iv.setFitWidth(155);

        buttonContainer[2] = noMilk;
        buttonContainer[2].setGraphic(iv);

        hbox.getChildren().add(buttonContainer[2]);

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

    public Button getRemove() { return remove; }

    public Button getOrderHistory() { return orderHistory; };

    public Button getInfo() { return info; }

    public Button getStorageContainer() { return  storageContainer; }



}

