package application;

import back_end.Container;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class StorageViewFX extends BorderPane {
    private String storageName;
    private Button back;

    public StorageViewFX(String s){
        this.storageName = s;
        back = new Button("[Back]");
        ImageView iv = new ImageView(new Image("wallpapers/woodWallpaper.jpg"));
        getChildren().add(iv);
    }

    public void displayStorage(){
        HBox hbox = new HBox();
        if(this.storageName.contains("Cereal")){
            for(int i = 0; i < Container.cerealContainer.length; i++){
                if(Container.cerealContainer[i] != null){
                    VBox cereal = oneStorageView(i,0);
                    hbox.getChildren().add(cereal);
                }
            }

            for(int i = 0; i <=1; i++){
                if(Container.milkContainer[i] != null){
                    VBox milk = oneStorageView(i, 1);
                    hbox.getChildren().add(milk);
                }
            }
            hbox.setSpacing(15.0);
            hbox.setPadding(new Insets(0,0,10.0,20.0));
            setBottom(hbox);
            title();
        }
    }

    public VBox oneStorageView(int index, int type) {
        VBox vbox = new VBox();
        if (this.storageName.contains("Cereal")) {
            Rectangle r = new Rectangle(100, Container.cerealContainer[index].getCapacity() * 3);
            Rectangle r2 = new Rectangle(100, Container.milkContainer[index].getCapacity() * 3);

            r.setFill(Color.TRANSPARENT);
            r.setStroke(Color.DARKCYAN);
            r.setStrokeWidth(3.0);

            r2.setFill(Color.TRANSPARENT);
            r2.setStroke(Color.STEELBLUE);
            r2.setStrokeWidth(3.0);
            if (type == 0) {
                Text cerealName = new Text(Container.cerealContainer[index].getName() + "\n(Container " + (index + 1) + ")");
                vbox.getChildren().addAll(r, cerealName);
            } else {
                Text milkName = new Text(Container.milkContainer[index].getName() + "\n(Container " + (index + 1) + ")");
                vbox.getChildren().addAll(r2, milkName);
            }

            vbox.setSpacing(15.0);

        }
        return vbox;
    }

    public void title(){
        HBox hbox = new HBox();

        back.setId("back");

        Text label = new Text(this.storageName);
        label.setId("title");

        hbox.setSpacing(180.0);
        hbox.setPadding(new Insets(30.0, 0, 0,0));


        hbox.getChildren().addAll(back, label);
        setTop(hbox);
    }

    public Button getBack(){return  this.back;}
}