package project.g7; 

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AdminWidget extends HBox{
    
    private CheckBox checkBox = new CheckBox();
    private Label name = new Label();
    private Label price = new Label();
    private Label region = new Label();
    private Label food = new Label();
    private Label openTime = new Label();
    private Label closeTime = new Label();
    private Label delivery = new Label();
    private Button removeButton = new Button("Remove");
    Restaurant restaurant;
    public AdminWidget(Boolean active,String name, String price, String region, String food, String openTime, String closeTime, boolean delivery,Restaurant restaurant){
        checkBox.selectedProperty().setValue(active);
        this.name.setText(name);
        this.price.setText(price);
        this.region.setText(region);
        this.food.setText(food);
        this.openTime.setText(openTime);
        this.closeTime.setText(closeTime);
        this.delivery.setText((delivery) ? "delivery" : "non-delivery");
        this.restaurant = restaurant;
        this.getChildren().addAll(checkBox,this.name,this.price,this.region,this.food,this.openTime,this.closeTime,this.delivery,removeButton);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        removeButton.setOnAction(event -> Main.controller.removeButton(this.name.getText(), this.region.getText()));

        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldVal, Boolean newVal){
                restaurant.setActiveStatus(newVal);
            }
        });
    }
}
