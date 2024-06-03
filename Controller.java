package project.g7;

import java.util.Optional;

import javafx.scene.control.ButtonType;

public class Controller {
    public Controller(){
        
    }

    public void searchButton(){
        Main.model.searchButton();
    }

    public void removeButton(String name, String region){
        Optional<ButtonType> result = Main.view.deleteAlert();
        String answer = result.get().getText();
        if(answer.equals("Yes")){
            Main.model.removeRestaurant(name,region);
        }
    }

    public void customerView(){ Main.model.startCustomerScreen(); }
    public void restaurateurView(){ Main.model.restaurateurView(); }
    public void adminView(){ Main.model.adminView(); }
}
