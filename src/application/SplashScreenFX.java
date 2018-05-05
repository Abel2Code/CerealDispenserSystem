package application;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class SplashScreenFX extends BorderPane {

    private Button done;
    private Label text;

    public SplashScreenFX(){

        done = new Button("Done");
        done.setId("button");
        ImageView image = new ImageView(new Image("wallpapers/woodWallpaper.jpg"));
        getChildren().addAll(image);
        setTop(text);


    }

    public void progress(int duration){
        VBox vbox = new VBox();

        done.setVisible(false);
        Task task = new Task<Void>(){
            @Override
            public Void call(){
                final int max = duration;
                for(int i = 1; i <= max; i++){
                    if(i == max){
                        done.setVisible(true);
                    }
                    updateProgress(i, max);
                }
                return null;
            }
        };
        ProgressBar p = new ProgressBar();
        p.setMinWidth(650);
        p.setMinHeight(50);
        p.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        vbox.getChildren().addAll(p, done);
        vbox.setSpacing(20.0);
        vbox.setPadding(new Insets(150,50,50,70));
        setCenter(vbox);

    }




    public Button getDone() {
        return done;
    }
}