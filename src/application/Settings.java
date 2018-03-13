package application;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Settings extends BorderPane{

	//Constructor
	public Settings() {
		ToggleButton button = new ToggleButton("hello");
		
			button.setOnAction(e -> button.setText("world"));
		
		setCenter(button);
		
	}
	
	
	
}
