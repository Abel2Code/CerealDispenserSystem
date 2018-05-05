package application;


import back_end.DataReader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class InformationFX extends BorderPane {
    private String text;
    private Button back;

    public InformationFX(){
        this.text = DataReader.readFile(DataReader.readMe);
        this.back = new Button("[Back]");
        ImageView iv = new ImageView(new Image("wallpapers/woodWallpaper.jpg"));
        getChildren().add(iv);
        title();
        scrollText();

    }

    public void scrollText(){
        ScrollPane s = new ScrollPane();
        Text document = new Text(this.text);
        s.setContent(document);
        s.setPadding(new Insets(20,0,0,250));
        s.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setCenter(s);
    }

    public void title(){
        HBox hbox = new HBox();

        back.setId("back");

        Text label = new Text("Information");
        label.setId("title");


        hbox.setSpacing(180.0);
        hbox.setPadding(new Insets(30.0, 0, 0,0));


        hbox.getChildren().addAll(back, label);
        setTop(hbox);
    }

    public Button getBack(){ return back; }

}
