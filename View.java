package project.g7;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class View extends BorderPane{

    
    //===============================================================================Alert
    private final ButtonType yesButton = new ButtonType("Yes");
    private final ButtonType noButton = new ButtonType("No");
    private final Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"",yesButton,noButton);
    //===============================================================================|

    //===============================================================================Menu Bar
    MenuBar menuBar = new MenuBar();
    Menu menuView = new Menu("View");
    MenuItem customerView = new MenuItem("Customer View");
    MenuItem restaurateurView = new MenuItem("Restaurateur View");
    MenuItem adminView = new MenuItem("Admin View");
    //===============================================================================|

    //===============================================================================Labels
    private Label screenTitleLabel = new Label("Pick Restaurant Analyser");
    private Label budgetLabel = new Label("Budget");
    private Label regionLabel = new Label("Region");
    private Label foodLabel = new Label("Cuisine");
    private Label timeLabel = new Label("Time");

    private Label restaurantLabel = new Label("Name");
    private Label closingTimeLabel = new Label("Closing Time");
    private Label deliveryLabel = new Label("Delivery");

    private Label infoLabel = new Label("Contact Number:1(123) 456-7890\tAdmin Training Date: November 32nd");
    //===============================================================================|

    //===============================================================================TextFields
    private TextField budgetTextField = new TextField();

    private TextField restaurantTextField = new TextField();
    //===============================================================================|

    //===============================================================================ComboBox
    private ObservableList<String> regionOptions = FXCollections.observableArrayList("Fredericton","Moncton","Saint John");
    private ComboBox<String> regionBox = new ComboBox<>(regionOptions);
    private ObservableList<String> foodOptions = FXCollections.observableArrayList("Italian","French","American","Canadian");
    private ComboBox<String> foodBox = new ComboBox<>(foodOptions);
    private ObservableList<String> timeOptions = FXCollections.observableArrayList(
        "12am","1am","2am","3am","4am","5am","6am","7am",
        "8am","9am","10am","11am","12pm","1pm","2pm","3pm","4pm","5pm",
        "6pm","7pm","8pm","9pm","10pm","11pm");
    private ComboBox<String> timeBox = new ComboBox<>(timeOptions);
    private ComboBox<String> closingTimeBox = new ComboBox<>(timeOptions);
    //===============================================================================|

    //===============================================================================CheckBox
    private CheckBox deliveryCheckBox = new CheckBox();
    //===============================================================================|

    //===============================================================================Buttons
    private Button searchButton = new Button("Search");
    //===============================================================================|

    //===============================================================================TableView
    private TableView<Restaurant> restaurantTable = new TableView<>();
    private TableColumn<Restaurant,String> nameColumn =  new TableColumn<>("Name");
    private TableColumn<Restaurant,Double> costColumn =  new TableColumn<>("Pricing");
    private TableColumn<Restaurant,String> regionColumn =  new TableColumn<>("Region");
    private TableColumn<Restaurant,String> foodColumn =  new TableColumn<>("Cuisine");
    private TableColumn<Restaurant,LocalTime> openColumn =  new TableColumn<>("Opens");
    private TableColumn<Restaurant,LocalTime> closeColumn =  new TableColumn<>("Closes");
    private TableColumn<Restaurant,Boolean> deliveryColumn = new TableColumn<>("Delivery");
    private TableColumn<Restaurant,Double> ratingColumn = new TableColumn<>("Rating");
    //===============================================================================|

    //===============================================================================Alignment Tools
    private VBox budgetVBox = new VBox(budgetLabel,budgetTextField);
    private VBox regionVBox = new VBox(regionLabel,regionBox);
    private VBox foodVBox = new VBox(foodLabel,foodBox);
    
    private VBox restaurantNameVBox = new VBox(restaurantLabel,restaurantTextField);
    private VBox openingTimeVBox = new VBox(timeLabel,timeBox);
    private VBox closingTimeVBox = new VBox(closingTimeLabel,closingTimeBox);
    private VBox deliveryVBox = new VBox(deliveryLabel,deliveryCheckBox);

    private HBox detailHBox = new HBox(budgetVBox,regionVBox,foodVBox);

    private HBox detailHBox2 = new HBox(detailHBox,searchButton);

    private HBox restaurantDetailHBox = new HBox(restaurantNameVBox,detailHBox,closingTimeVBox,deliveryVBox);

    private VBox initVBox = new VBox();
    private VBox searchVBox = new VBox(detailHBox2);

    private VBox adminVBox = new VBox();

    private HBox infoHBox = new HBox(infoLabel);
    //===============================================================================|

    //===============================================================================ScrollPane
    ScrollPane scrollPane = new ScrollPane(adminVBox);
    //===============================================================================|

    public View(){
        budgetTextField.textProperty().addListener(new ChangeListener<String>() {// This entire listener is here to only allow numbers in the specified textfield
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    budgetTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        menuView.getItems().addAll(customerView,restaurateurView,adminView);
        menuBar.getMenus().add(menuView);

        customerView.setOnAction(event -> Main.controller.customerView());
        restaurateurView.setOnAction(event -> Main.controller.restaurateurView());
        adminView.setOnAction(event -> Main.controller.adminView());

        searchButton.setOnAction(event -> Main.controller.searchButton());

        budgetTextField.setPrefWidth(50);

        restaurantTextField.setPrefWidth(70);

        screenTitleLabel.setFont(Font.font("Arial",30));

        detailHBox.setAlignment(Pos.CENTER);
        detailHBox.setSpacing(10);
        initVBox.setAlignment(Pos.CENTER);
        initVBox.setSpacing(10);

        budgetVBox.setAlignment(Pos.CENTER);
        budgetVBox.setSpacing(10);
        regionVBox.setAlignment(Pos.CENTER);
        regionVBox.setSpacing(10);
        foodVBox.setAlignment(Pos.CENTER);
        foodVBox.setSpacing(10);
        adminVBox.setSpacing(10);
        
        scrollPane.setFitToHeight(true);
        
        restaurantNameVBox.setAlignment(Pos.CENTER);
        restaurantNameVBox.setSpacing(10);
        openingTimeVBox.setAlignment(Pos.CENTER);
        openingTimeVBox.setSpacing(10);
        closingTimeVBox.setAlignment(Pos.CENTER);
        closingTimeVBox.setSpacing(10);
        deliveryVBox.setAlignment(Pos.CENTER);
        deliveryVBox.setSpacing(10);

        detailHBox2.setAlignment(Pos.CENTER);
        detailHBox2.setSpacing(10);
        searchVBox.setAlignment(Pos.CENTER);
        searchVBox.setSpacing(10);

        
        restaurantDetailHBox.setAlignment(Pos.CENTER);
        restaurantDetailHBox.setSpacing(10);

        restaurantTable.setEditable(false);
        nameColumn.setSortable(false);
        costColumn.setSortable(false);
        regionColumn.setSortable(false);
        foodColumn.setSortable(false);
        openColumn.setSortable(false);
        closeColumn.setSortable(false);

        infoHBox.setAlignment(Pos.CENTER);
    }

    public void setToInitialCustomerView(){
        this.getChildren().clear();
        cleanSelection();
        setBar();
        this.setBottom(infoHBox);
        initVBox.getChildren().addAll(screenTitleLabel,detailHBox,searchButton);
        screenTitleLabel.setText("Pick Restaurant Analyser");
        searchButton.setText("Search");
        budgetLabel.setText("Budget");
        this.setCenter(initVBox);
    }

    public String getName(){ return restaurantTextField.getText(); }
    public double getBudget(){ return Double.parseDouble(budgetTextField.getText()); }
    public String getRegion(){ return regionBox.getValue(); }
    public String getFood(){ return foodBox.getValue(); }
    public LocalTime getOpenTime(){
        return LocalTime.of(timeBox.getSelectionModel().getSelectedIndex(),0,0,0);
    }
    public LocalTime getClosingTime(){
        return LocalTime.of(closingTimeBox.getSelectionModel().getSelectedIndex(),0,0,0);
    }
    public boolean getDelivery(){ return deliveryCheckBox.selectedProperty().getValue(); }

    public void setToCustomerSearchView(){
        this.getChildren().clear();
        cleanSelection();
        setBar();
        detailHBox2.getChildren().addAll(detailHBox,searchButton);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("restaurantName"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,Double>("averagePrice"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("regionName"));
        foodColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("foodType"));
        openColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,LocalTime>("openHours"));
        closeColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,LocalTime>("closeHours"));
        deliveryColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,Boolean>("deliveryOption"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<Restaurant,Double>("rating"));
        ObservableList<Restaurant> items = FXCollections.observableArrayList();
        items.addAll(Main.model.getFullOrderedRestaurantList());
        restaurantTable.setItems(items);
        restaurantTable.getColumns().addAll(nameColumn,costColumn,regionColumn,foodColumn,openColumn,closeColumn,deliveryColumn,ratingColumn);
        searchVBox.getChildren().addAll(detailHBox2,restaurantTable);
        this.setCenter(searchVBox);
    }

    public void setToRestaurateurView(){
        this.getChildren().clear();
        cleanSelection();
        setBar();
        restaurantDetailHBox.getChildren().addAll(restaurantNameVBox,detailHBox,openingTimeVBox,closingTimeVBox,deliveryVBox);
        initVBox.getChildren().addAll(screenTitleLabel,restaurantDetailHBox,searchButton);
        screenTitleLabel.setText("Restaurant Details");
        searchButton.setText("Add Restaurant");
        budgetLabel.setText("Avg Price");
        this.setCenter(initVBox);
    }

    public void setToAdminView(){
        this.getChildren().clear();
        cleanSelection();
        setBar();
        ArrayList<Restaurant> restaurants = Main.model.getRestaurants();
        for(int i = 0; i < restaurants.size(); i++){
            Restaurant nextRestaurant = restaurants.get(i);
            AdminWidget newAdminRestaurantHBox = new AdminWidget(nextRestaurant.getActiveStatus(),nextRestaurant.getRestaurantName(),Double.toString(nextRestaurant.getAveragePrice()),nextRestaurant.getRegionName(),nextRestaurant.getFoodType(),nextRestaurant.getOpenHours().toString(),nextRestaurant.getCloseHours().toString(),nextRestaurant.getDeliveryOption(),nextRestaurant);
            adminVBox.getChildren().add(newAdminRestaurantHBox);
        }
        this.setCenter(scrollPane);
    }

    public void setBar(){ this.setTop(menuBar); }

    public void cleanSelection(){ 
        detailHBox2.getChildren().clear();
        searchVBox.getChildren().clear();
        initVBox.getChildren().clear();
        restaurantTable.getColumns().clear();
        restaurantDetailHBox.getChildren().clear();
        restaurantTextField.setText("");
        budgetTextField.setText("");
        regionBox.getSelectionModel().selectFirst();
        foodBox.getSelectionModel().selectFirst();
        timeBox.getSelectionModel().selectFirst();
        closingTimeBox.getSelectionModel().selectFirst();
        adminVBox.getChildren().clear();
    }

    public Optional<ButtonType> deleteAlert(){
        alert.setTitle("Delete Restaurant");
        alert.setHeaderText("Are you sure you want to delete the Restaurant?");
        return alert.showAndWait();
    }
}
