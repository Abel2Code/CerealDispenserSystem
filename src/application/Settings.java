package application;

import back_end.*;

import back_end.Container;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
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
		getChildren().addAll(iv);
		setCenter(scroll(gridOfCereal(cereals)));
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
		sp.setFitToWidth(true);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sp.setContent(gp);

		return sp;
	}

	public GridPane gridOfCereal(List<Cereal> cereals){

		int counter = 0;
		GridPane gp = new GridPane();

		gp.setHgap(10.0);
		gp.setVgap(10.0);

		int x = cereals.size();
		int y = 1;

		if (x > 4) {
            y = (int) Math.ceil(x / 4.0);
		    x = 4;
        }

		for(int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
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


	/*
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
	*/
	
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
        RadioButton[] rb = new RadioButton[5];
        ToggleGroup group = new ToggleGroup();
        rb[0] = new RadioButton("Alphabetical");
        rb[1] = new RadioButton("Most Calories");
        rb[2] = new RadioButton("Most Fat");
        rb[3] = new RadioButton("Most Carbs");
        rb[4] = new RadioButton("Most Protein");

        rb[0].setUserData("alphabetical");
		rb[1].setUserData("calories");
		rb[2].setUserData("fat");
		rb[3].setUserData("carbs");
		rb[4].setUserData("protein");



		for(int i = 0; i < rb.length; i++ ){
            if(i == 0){
                rb[i].setSelected(true);
            }
            rb[i].setToggleGroup(group);
            vbox.getChildren().add(rb[i]);
        }


        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                final CerealListSorter cls =
                        new CerealListSorter(group.getSelectedToggle().getUserData().toString());

                cereals = cls.cereals;
                setCenter(scroll(gridOfCereal(cereals)));

            }


        });


		TextField search = new TextField();
		search.setPromptText("By Name");
		search.setMaxWidth(100);
		search.setOnAction(e -> findCereal(search.getText()));
		Button searchButton = new Button("Search");
		searchButton.setOnAction(e -> findCereal(search.getText()));

		VBox searchVB = new VBox();
		Label emptySpace = new Label("");
		searchVB.getChildren().addAll(emptySpace, search, searchButton);

		vbox.getChildren().add(searchVB);

	    return vbox;
    }

    public VBox title(){
	    VBox vbox = new VBox();
	    HBox hbox = new HBox();
	    Label title = new Label("Cereals");
	    this.settingToMain = new Button("Back");
	    Label description = new Label("Please Select A Cereal:");
	    hbox.getChildren().addAll(settingToMain, title);
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
	    name.setMaxWidth(200);
        name.setTextOverrun(OverrunStyle.ELLIPSIS);
	    Label calories = new Label("Calorie(s): " + selectedCereal.getCalories() + " (cal)");
	    Label fat = new Label("Fat(s): " + selectedCereal.getFat() + " (g)");
	    Label carbs = new Label("Carb(s): " + selectedCereal.getCarbs() + " (g)");
	    Label protein = new Label("Protein: " + selectedCereal.getProtein() + " (g)");
	    Button select = new Button("SELECT");

	    VBox infoBox = new VBox();
	    infoBox.setId("infoBox");
	    infoBox.getChildren().addAll(name, calories, fat, carbs, protein);

	    select.setMinWidth(200);
	    vbox.getChildren().addAll(picOfCereal, infoBox, select);
	    vbox.setAlignment(Pos.TOP_CENTER);
        setRight(vbox);

        return vbox;
    }

    public int hello(){
	    return 5;
    }

    public Button getSettingToMain() {
		return settingToMain;
	}

	private void findCereal(String cerealName) {
	    List<Cereal> matches = new ArrayList<>();

	    for(Cereal c : cereals) {
	        if (cerealName.toLowerCase().equals(c.getName().toLowerCase())) {
	            this.selectedCereal = c;
	            matches.add(c);
            } else {
	            Cereal tmp = searchHelper(cerealName, c);

	            if (tmp != null) {
	                matches.add(tmp);
                }
            }
        }

        if (!matches.isEmpty()) {
	        setCenter(scroll(gridOfCereal(matches)));
        }
    }

    private Cereal searchHelper(String name, Cereal c) {
        String[] arr = c.getName().split(" ");

        for (String s : arr) {
            if (name.toLowerCase().equals(s.toLowerCase())) {
                return c;
            }
        }

        return null;
    }


}
