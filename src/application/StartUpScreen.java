package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class StartUpScreen extends StackPane{
    private Text time;

	public StartUpScreen() {
		Image image = new Image("wallpapers/cerealWallpaper.jpg");
		ImageView view = new ImageView(image);
		Label label = new Label();
		startTime();
		label.setGraphic(view);
		label.setMinWidth(800.0);
		label.setMinHeight(480.0);

	    time.setId("touchToBegin");
	    Label touch = new Label("Touch to begin");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(time, touch);

        getChildren().addAll(label, vbox);
	    
	    vbox.setAlignment(Pos.CENTER);
	}

    private void startTime() {
        time = new Text();

        DateFormat tf = new SimpleDateFormat("hh:mm aa");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            Calendar currentTime = Calendar.getInstance();
                            time.setText(tf.format(currentTime.getTime()));
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
	
}
