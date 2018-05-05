package application;

import back_end.Cereal;
import back_end.Container;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CerealListFx extends BorderPane{
    private Button toMain;
    private Button selectButton;
    private VBox displayChosenCereal;
    public static Cereal selectedCereal;
    private List<Cereal> cereals = Container.cereals;

    //Constructor
    public CerealListFx() {
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

        //--------------
        setTop(title);
        setLeft(sortBy);
        setRight(cerealSelect());
        Text txt = new Text();
        setBottom(txt);

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
            if (i == y - 1) {
                x = cereals.size() % 4;
            }
            for (int j = 0; j < x; j++) {
                Button btn = new Button();
                btn.setId(Integer.toString(counter));
                btn.setOnAction(event -> {
                    int cerealId = Integer.parseInt(btn.getId());
                    this.selectedCereal = cereals.get(cerealId);
                    changeChosenCerealImage();
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
        searchButton.setId("selectButton");
        searchButton.setMinWidth(100.0);
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
        Text title = new Text("Select Cereal Brand");
        title.setId("title");

        toMain = new Button("[Back]");
        toMain.setId("back");

        hbox.getChildren().addAll(toMain, title);

        hbox.setSpacing(100.0);
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
        name.setMaxWidth(200);
        name.setTextOverrun(OverrunStyle.ELLIPSIS);
        Label calories = new Label("Calorie(s): " + selectedCereal.getCalories() + " (cal)");
        Label fat = new Label("Fat(s): " + selectedCereal.getFat() + " (g)");
        Label carbs = new Label("Carb(s): " + selectedCereal.getCarbs() + " (g)");
        Label protein = new Label("Protein: " + selectedCereal.getProtein() + " (g)");

        selectButton = new Button("SELECT");

        selectButton.setId("selectButton");


        VBox infoBox = new VBox();
        infoBox.setId("infoBox");
        infoBox.getChildren().addAll(name, calories, fat, carbs, protein);

        selectButton.setMinWidth(190);
        displayChosenCereal.getChildren().addAll(picOfCereal, infoBox, selectButton);
        displayChosenCereal.setAlignment(Pos.TOP_CENTER);
        setRight(displayChosenCereal);

        return displayChosenCereal;
    }


    public Button getSelectButton() {
        return selectButton;
    }

    public Button getToMain() {
        return toMain;
    }

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

        VBox infoBox = new VBox();
        infoBox.setId("infoBox");
        infoBox.getChildren().addAll(name, calories, fat, carbs, protein);

        this.displayChosenCereal.getChildren().set(0,picOfCereal);
        this.displayChosenCereal.getChildren().set(1, infoBox);
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
