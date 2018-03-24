package application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;


public class Settings extends BorderPane{
	private Button settingToMain;

	//Constructor
	public Settings() {
		Image img = new Image("cerealWallpaper.jpg");
		ImageView iv = new ImageView(img);
		getChildren().addAll(iv,topPane());
	}
	
	public void middlePane() {
		
	}
	
	public HBox topPane() {
		HBox title = new HBox();
		this.settingToMain = new Button("<");
		this.settingToMain.setId("settingToMain");
		this.settingToMain.setShape(new Circle(700.0));
		Label settingTitle = new Label("Settings");
		settingTitle.setId("settingTitle");
		title.getChildren().addAll(this.settingToMain, settingTitle);
		return title;
	}
	
	/**
	 * 
	 * @param s The string variable that is going to be placed inside each setting label
	 * @return - returns one setting Label Node.
	 */
	public Label makeSettingLabel(String s) {
		Label label = new Label(s);
		label.setId("settingLabel");
		return label;
		
	}
	
	
	
}
