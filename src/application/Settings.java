package application;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;


public class Settings extends BorderPane{

	//Constructor
	public Settings() {
		ToggleButton button = new ToggleButton("hello");
		
			button.setOnAction(e -> button.setText("world"));
		
		setCenter(button);
		
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
