package application;

import back_end.*;

import back_end.Container;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;


public class Settings extends BorderPane{
	private Button settingToMain;
	private Cereal selectedCereal;
	private List<Cereal> cereals = Container.cereals;

	//Constructor
	public Settings() {
	    this.selectedCereal = Container.cereals.get(0);
		Image img = new Image("wallpapers/woodWallpaper.jpg");
		ImageView iv = new ImageView(img);
		getChildren().addAll(iv,topPane());
		setCenter(scroll(gridOfCereal()));
		VBox sortBy = organizeBy();
		VBox title = title();
		VBox selection = cerealSelect();
		//move to the methods
        sortBy.setMinWidth(110.0);
		selection.setMinWidth(200.0);
		setAlignment(title, Pos.TOP_RIGHT);
		//--------------
		setTop(title);
		setLeft(sortBy);

	}
	
	public ScrollPane scroll(GridPane gp) {
		ScrollPane sp = new ScrollPane();
		StackPane stack = new StackPane();
		Rectangle background = new Rectangle();
		Image img = new Image("wallpapers/loopsWallpaper.jpg");
		ImageView imgV = new ImageView(img);
		background.setFill(Color.BLACK);
		background.setHeight(1650);
		background.setWidth(500);
		stack.getChildren().addAll(background, gp);
		sp.setFitToWidth(true);
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
                    this.selectedCereal = cereals.get(cerealId);
                    setRight(cerealSelect());
                    //TESTER
                    //System.out.println(Container.cereals.get(cerealId).getName());
                });
				Image img = new Image(cereals.get(counter).getImage());
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

	public VBox organizeBy(){
	    VBox vbox = new VBox();
        RadioButton[] rb = new RadioButton[4];
        ToggleGroup group = new ToggleGroup();
        rb[0] = new RadioButton("Alphabetical");
        rb[1] = new RadioButton("Most Calories");
        rb[2] = new RadioButton("Most Fat");
        rb[3] = new RadioButton("Most Carbs");

        rb[0].setUserData("alphabetical");
		rb[1].setUserData("calories");
		rb[2].setUserData("fat");
		rb[3].setUserData("carbs");



		for(int i = 0; i < rb.length; i++ ){
            if(i == 0){
                rb[i].setSelected(true);
            }
            rb[i].setToggleGroup(group);
            vbox.getChildren().add(rb[i]);
        }


        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov,
								Toggle old_toggle, Toggle new_toggle) {
				if (group.getSelectedToggle() != null) {
					final CerealListSorter cls =
							new CerealListSorter(group.getSelectedToggle().getUserData().toString());

					cereals = cls.cereals;
					setCenter(scroll(gridOfCereal()));

				}


			}
		});


	    return vbox;
    }

    public VBox title(){
	    VBox vbox = new VBox();
	    HBox hbox = new HBox();
	    Label title = new Label("Cereals");
	    Button back = new Button("Back");
	    Label description = new Label("Please Select A Cereal:");
	    hbox.getChildren().addAll(back, title);
	    vbox.getChildren().addAll(hbox, description);
	    return vbox;
    }

    public VBox cerealSelect(){
	    VBox vbox = new VBox();
	    Image img = new Image(this.selectedCereal.getImage());
	    ImageView imgV = new ImageView(img);
	    Label picOfCereal = new Label();
	    picOfCereal.setGraphic(imgV);
	    Label name = new Label("Cereal Name: " + selectedCereal.getName());
	    Label calories = new Label("Calorie(s): " + selectedCereal.getCalories() + " (cal)");
	    Label fat = new Label("Fat(s): " + selectedCereal.getFat() + " (g)");
	    Label carbs = new Label("Carb(s): " + selectedCereal.getCarbs() + " (g)");
	    Label protein = new Label("Protein: " + selectedCereal.getProtein() + " (g)");
	    Button select = new Button("SELECT");
	    select.setMinWidth(200);
	    vbox.getChildren().addAll(picOfCereal, name, calories, fat, carbs, protein, select);
        setRight(vbox);
        return vbox;
    }

    public int hello(){
	    return 5;
    }
	
}
