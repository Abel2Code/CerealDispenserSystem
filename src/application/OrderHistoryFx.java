package application;

import back_end.Container;
import back_end.Order;
import back_end.OrderHistory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class OrderHistoryFx extends BorderPane {
    private Button backButton;
    private Button[] buttonContainer;
    private GridPane gp;

    public OrderHistoryFx() {
        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView iv = new ImageView(img);
        getChildren().addAll(iv);

        top();
        history();
        initializeButtons();
    }

    public void top(){
        HBox hbox = new HBox();
        backButton = new Button("[Back]");
        backButton.setId("back");

        Text label = new Text("Order History");
        label.setId("title");

        Button notifications = new Button("!");
        notifications.setId("notifications");

        hbox.setSpacing(204.0);
        hbox.setPadding(new Insets(30.0, 0, 0,0));

        hbox.getChildren().addAll(backButton, label, notifications);
        setTop(hbox);
    }

    public void initializeButtons() {
        buttonContainer = new Button[10];

        for (int i = 0 ; i < 10 ; i++) {
            buttonContainer[i] = new Button("Reorder");
            buttonContainer[i].setId("reorderButton");
        }
    }

    public void history() {
        gp = new GridPane();
        gp.setHgap(40.0);
        gp.setVgap(10.0);
        gp.setAlignment(Pos.TOP_CENTER);

        Text name = new Text("Cereal");
        Text milk = new Text("Milk");
        Text milkExp = new Text("Milk Expiration Date");
        Text portion = new Text("Size");
        Text button = new Text("Button");

        name.setId("header");
        milk.setId("header");
        milkExp.setId("header");
        portion.setId("header");
        button.setId("header");

        gp.add(name, 0, 0);
        gp.add(milk, 1, 0);
        gp.add(milkExp, 2, 0);
        gp.add(portion, 3, 0);
        gp.add(button, 4, 0);

        setCenter(gp);
    }

    public void updateHistory() {
        history();

        int size = OrderHistory.orders.size();

        int x = size;

        if (size > 10) {
            x = 10;
        }

        for (int i = size, j = 0 ; j <  x  ; i--, j++) {

            Order o = OrderHistory.orders.get(i - 1);

            Label cereal = new Label(o.getCereal().getName());
            Label milkName = new Label(o.getMilk().getName());
            Label expDate = new Label(o.getMilk().getExpirationDate());
            Label portion = new Label(getSize(o.getPortion()));
            Button reorder;

            if (Container.getCerealIndex(o.getCereal()) != -1 &&
                    (Container.getMilkIndex(o.getMilk()) != -1)) {
                reorder = buttonContainer[j];
                reorder.setId("reorderButton");

            }
            else {
                reorder = new Button("No longer Available");
                reorder.setId("disabled");
            }

            cereal.setId("data");
            milkName.setId("data");
            expDate.setId("data");
            portion.setId("data");

            gp.add(cereal, 0, j + 1);
            gp.add(milkName, 1, j + 1);
            gp.add(expDate, 2, j + 1);
            gp.add(portion, 3, j + 1);
            gp.add(reorder, 4, j + 1);

        }

        setCenter(gp);
    }

    public String getSize(int x) {
        if (x == 0) {
            return "Small";
        } else if (x == 1) {
            return "Medium";
        } else {
            return "Large";
        }
    }

    public Button getBackButton() { return backButton; }

    public Button[] getButtonContainer() { return buttonContainer; }


}
