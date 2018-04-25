package application;

import back_end.*;

import back_end.Container;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class CerealListFx extends BorderPane{
	private Button toMain;
	private Button selectButton;
	private VBox displayChosenCereal;
	public static Cereal selectedCereal;

	//Constructor
	public CerealListFx() {
	    this.selectedCereal = Container.cereals.get(0);

		Image img = new Image("wallpapers/woodWallpaper.jpg");
		ImageView iv = new ImageView(img);
		getChildren().addAll(iv);
		setCenter(scroll(gridOfCereal()));
		VBox sortBy = organizeBy();
		VBox title = title();
		VBox selection = cerealSelect();
		//move to the methods
        sortBy.setMinWidth(110.0);
		selection.setMinWidth(200.0);

		//--------------
		setTop(title);
		setLeft(sortBy);
		setRight(cerealSelect());
		Text txt = new Text();
		setBottom(txt);

	}
	
	public ScrollPane scroll(GridPane gp) {
		ScrollPane sp = new ScrollPane();
		StackPane stack = new StackPane();
		Rectangle background = new Rectangle();
		Image img = new Image("wallpapers/woodWallpaper.jpg");

		background.setFill(new ImagePattern(img));
		background.setHeight(1650);
		background.setWidth(500);
		stack.getChildren().addAll(background, gp);
		sp.setFitToWidth(true);
		sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sp.setContent(stack);

		return sp;
	}

	public GridPane gridOfCereal(){
		int counter = 0;
		GridPane gp = new GridPane();

		gp.setHgap(10.0);
		gp.setVgap(10.0);
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				Button btn = new Button();
				btn.setId(Integer.toString(counter));
                btn.setOnAction(event -> {
                    int cerealId = Integer.parseInt(btn.getId());
                    this.selectedCereal = Container.cereals.get(cerealId);
                    changeChosenCerealImage();
                    //TESTER
                    //System.out.println(Container.cereals.get(cerealId).getName());
                });
				Image img = new Image(Container.cereals.get(counter).getImage());
				ImageView imgV = new ImageView(img);
                imgV.setFitHeight(140);
                imgV.setFitWidth(98);
				btn.setGraphic(imgV);
				gp.add(btn, j, i);
				if(counter <= 31);{
				    counter++;
                }
			}
		}
		return gp;
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

	public VBox organizeBy(){
	    VBox vbox = new VBox();
        RadioButton[] rb = new RadioButton[4];
        ToggleGroup group = new ToggleGroup();
        rb[0] = new RadioButton("Alphabetical");
        rb[1] = new RadioButton("Most Calories");
        rb[2] = new RadioButton("Most Fat");
        rb[3] = new RadioButton("Most Carbs");
        for(int i = 0; i < rb.length; i++ ){
            if(i == 0){
                rb[i].setSelected(true);
            }
            rb[i].setToggleGroup(group);
            vbox.getChildren().add(rb[i]);
        }
	    return vbox;
    }

    public VBox title(){
	    VBox vbox = new VBox();
	    HBox hbox = new HBox();
	    Text title = new Text("Select a Cereal");
        title.setFill(Color.valueOf("#1294FF"));
        title.setFont(Font.font("Helvetica", FontWeight.BOLD, 43.0));
	    toMain = new Button("[Back]");
        toMain.setTextFill(Color.RED);
        toMain.setMinSize(80.0, 50.0);
        toMain.setStyle("-fx-background-color: Transparent");
	    Label description = new Label("Please Select A Cereal:");
	    hbox.getChildren().addAll(toMain, title);
	    hbox.setSpacing(180.0);
	    hbox.setPadding(new Insets(10.0,0,5.0,10.0));
	    vbox.getChildren().add(hbox);

	    return vbox;
    }

    public VBox cerealSelect(){
	    displayChosenCereal = new VBox();
	    Image img = new Image(this.selectedCereal.getImage());
	    ImageView imgV = new ImageView(img);
	    Label picOfCereal = new Label();
	    picOfCereal.setGraphic(imgV);
	    Label name = new Label(selectedCereal.getName());
	    Label calories = new Label("Calorie(s): " + selectedCereal.getCalories() + " (cal)");
	    Label fat = new Label("Fat(s): " + selectedCereal.getFat() + " (g)");
	    Label carbs = new Label("Carb(s): " + selectedCereal.getCarbs() + " (g)");
	    Label protein = new Label("Protein: " + selectedCereal.getProtein() + " (g)");
	    selectButton = new Button("SELECT");
        selectButton.setMinSize(10,10);
        selectButton.setStyle("-fx-background-color: Transparent; -fx-border-color: Black; -fx-border-width: 2.0; -fx-border-radius: 30.0;");
        selectButton.setFont(Font.font("Helvetica", FontWeight.BOLD, 15.0));
	    selectButton.setMinWidth(190);

	    displayChosenCereal.setPadding(new Insets(0,10.0,0,10.0));
	    displayChosenCereal.getChildren().addAll(picOfCereal, name, calories, fat, carbs, protein, selectButton);

        return displayChosenCereal;
    }

    public void bottom(){
	    Label label = new Label("");
	    label.setMinWidth(1000);
	    label.setPadding(new Insets(10.0,0,0,0));

    }

    public Button getSelectButton(){
	    return selectButton;
    }

    public Button getToMain(){ return toMain; }

    public void changeChosenCerealImage(){
        Image img = new Image(this.selectedCereal.getImage());
        ImageView imgV = new ImageView(img);
        Label picOfCereal = new Label();
        picOfCereal.setGraphic(imgV);
        Label name = new Label(selectedCereal.getName());
        Label calories = new Label("Calorie(s): " + selectedCereal.getCalories() + " (cal)");
        Label fat = new Label("Fat(s): " + selectedCereal.getFat() + " (g)");
        Label carbs = new Label("Carb(s): " + selectedCereal.getCarbs() + " (g)");
        Label protein = new Label("Protein: " + selectedCereal.getProtein() + " (g)");
        this.displayChosenCereal.getChildren().set(0,picOfCereal);
        this.displayChosenCereal.getChildren().set(1, name);
        this.displayChosenCereal.getChildren().set(2,calories);
        this.displayChosenCereal.getChildren().set(3,fat);
        this.displayChosenCereal.getChildren().set(4,carbs);
        this.displayChosenCereal.getChildren().set(5,protein);

    }
	
}
