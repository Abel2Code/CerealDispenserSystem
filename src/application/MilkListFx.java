package application;

import back_end.Milk;
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

public class MilkListFx extends BorderPane{
    private Button toMain;
    private Button selectButton;
    private VBox displayChosenMilk;
    public static Milk selectedMilk;
    private List<Milk> milks = Container.milks;

    //Constructor
    public MilkListFx() {
        this.selectedMilk = Container.milks.get(0);

        Image img = new Image("wallpapers/woodWallpaper.jpg");
        ImageView iv = new ImageView(img);
        getChildren().addAll(iv);
        setCenter(scroll(gridOfMilk(milks)));
        VBox sortBy = organizeBy();
        VBox title = title();
        VBox selection = milkSelect();

        //move to the methods
        sortBy.setMinWidth(110.0);
        selection.setMinWidth(200.0);

        //--------------
        setTop(title);
        setLeft(sortBy);
        setRight(milkSelect());
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

    public GridPane gridOfMilk(List<Milk> milks){

        int counter = 0;
        GridPane gp = new GridPane();

        gp.setHgap(10.0);
        gp.setVgap(10.0);

        int x = milks.size();
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
                    int milkId = Integer.parseInt(btn.getId());
                    this.selectedMilk = milks.get(milkId);
                    changeChosenMilkImage();
                    //TESTER
                    //System.out.println(Container.milks.get(milkId).getName());
                });
                Image img = new Image(milks.get(counter).getImage());
                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(140);
                imgV.setFitWidth(98);
                btn.setGraphic(imgV);
                gp.add(btn, j, i);
                if(counter != 12);{
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
                final MilkListSorter mls =
                        new MilkListSorter(group.getSelectedToggle().getUserData().toString());

                milks = mls.milks;
                setCenter(scroll(gridOfMilk(milks)));

            }


        });


        TextField search = new TextField();
        search.setPromptText("By Name");
        search.setMaxWidth(100);
        search.setOnAction(e -> findMilk(search.getText()));
        Button searchButton = new Button("Search");
        searchButton.setId("selectButton");
        searchButton.setMinWidth(100.0);
        searchButton.setOnAction(e -> findMilk(search.getText()));

        VBox searchVB = new VBox();
        Label emptySpace = new Label("");
        searchVB.getChildren().addAll(emptySpace, search, searchButton);

        vbox.getChildren().add(searchVB);

        return vbox;
    }

    public VBox title(){
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Text title = new Text("Select Milk Type");
        title.setId("title");

        toMain = new Button("[Back]");
        toMain.setId("back");

        hbox.getChildren().addAll(toMain, title);

        hbox.setSpacing(160.0);
        hbox.setPadding(new Insets(10.0,0,5.0,10.0));

        vbox.getChildren().add(hbox);

        return vbox;
    }

    public VBox milkSelect(){
        displayChosenMilk = new VBox();
        Image img = new Image(this.selectedMilk.getImage());
        ImageView imgV = new ImageView(img);
        imgV.setFitHeight(250);
        imgV.setFitWidth(175);
        Label picOfMilk = new Label();
        picOfMilk.setGraphic(imgV);
        Label name = new Label(selectedMilk.getName());
        name.setMaxWidth(200);
        name.setTextOverrun(OverrunStyle.ELLIPSIS);
        Label calories = new Label("Calorie(s): " + selectedMilk.getCalories() + " (cal)");
        Label fat = new Label("Fat(s): " + selectedMilk.getFat() + " (g)");
        Label carbs = new Label("Carb(s): " + selectedMilk.getCarbs() + " (g)");
        Label protein = new Label("Protein: " + selectedMilk.getProtein() + " (g)");

        selectButton = new Button("SELECT");
        selectButton.setId("selectButton");

        VBox infoBox = new VBox();
        infoBox.setId("infoBox");
        infoBox.getChildren().addAll(name, calories, fat, carbs, protein);

        selectButton.setMinWidth(200);
        displayChosenMilk.getChildren().addAll(picOfMilk, infoBox, selectButton);
        displayChosenMilk.setAlignment(Pos.TOP_CENTER);
        setRight(displayChosenMilk);

        return displayChosenMilk;
    }


    public Button getSelectButton() {
        return selectButton;
    }

    public Button getToMain() {
        return toMain;
    }

    public void changeChosenMilkImage(){
        Image img = new Image(this.selectedMilk.getImage());
        ImageView imgV = new ImageView(img);
        imgV.setFitHeight(250);
        imgV.setFitWidth(175);
        Label picOfMilk = new Label();
        picOfMilk.setGraphic(imgV);

        Label name = new Label(selectedMilk.getName());
        Label calories = new Label("Calorie(s): " + selectedMilk.getCalories() + " (cal)");
        Label fat = new Label("Fat(s): " + selectedMilk.getFat() + " (g)");
        Label carbs = new Label("Carb(s): " + selectedMilk.getCarbs() + " (g)");
        Label protein = new Label("Protein: " + selectedMilk.getProtein() + " (g)");

        VBox infoBox = new VBox();
        infoBox.setId("infoBox");
        infoBox.getChildren().addAll(name, calories, fat, carbs, protein);

        this.displayChosenMilk.getChildren().set(0, picOfMilk);
        this.displayChosenMilk.getChildren().set(1, infoBox);
    }

    private void findMilk(String milkName) {
        List<Milk> matches = new ArrayList<>();

        for(Milk c : milks) {
            if (milkName.toLowerCase().equals(c.getName().toLowerCase())) {
                this.selectedMilk = c;
                matches.add(c);
            } else {
                Milk tmp = searchHelper(milkName, c);

                if (tmp != null) {
                    matches.add(tmp);
                }
            }
        }

        if (!matches.isEmpty()) {
            setCenter(scroll(gridOfMilk(matches)));
        }
    }

    private Milk searchHelper(String name, Milk c) {
        String[] arr = c.getName().split(" ");

        for (String s : arr) {
            if (name.toLowerCase().equals(s.toLowerCase())) {
                return c;
            }
        }

        return null;
    }

}
