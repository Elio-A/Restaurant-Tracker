package project.g7;

import java.time.LocalTime;
import java.util.ArrayList;

public class Model {
    
    private String currentScreen = "";
    private RegionList regionList;
    private Customer customer;
    public Model(){
        defaultRegions();
    }

    public ArrayList<Restaurant> getFullOrderedRestaurantList(){
        return regionList.getFullOrderedRestaurantList(customer);
    }

    public ArrayList<Restaurant> getRestaurants(){ 
        ArrayList<Region> regions = regionList.getRegionLst();
        ArrayList<Restaurant> allRestaurants = new ArrayList<>();
        for(int i = 0; i < regions.size(); i++){
            Region currentRegion = regions.get(i);
            allRestaurants.addAll(currentRegion.getRestaurants());
        }
        return allRestaurants;
    }

    public void defaultRegions(){
        LocalTime timeOpen = LocalTime.MIN;
        LocalTime timeClose = LocalTime.MAX;
       
        LocalTime timeOpen2 = LocalTime.of(10,0,0,0);
        LocalTime timeClose2 = LocalTime.of(12,0,0,0);
       
        Restaurant res1Reg1 = new Restaurant("PizzeriaPlace","Fredericton","Italian", timeOpen, timeClose, true, 5, 20);
        Restaurant res2Reg1 = new Restaurant("BaguetteForgetti","Fredericton","French", timeOpen, timeClose, false, 5, 100);
        Restaurant res3Reg1 = new Restaurant("SpaghettNoRegret","Fredericton","Italian", timeOpen, timeClose, true, 5, 49);
       
        Restaurant res1Reg2 = new Restaurant("PleaseBurger","Moncton","American", timeOpen2, timeClose2, true, 5, 70);
        Restaurant res2Reg2 = new Restaurant("Meatball Emporium","Moncton","Italian", timeOpen2, timeClose2, true, 5, 49);
        Restaurant res3Reg2 = new Restaurant("PoutineYerMouth","Moncton","Canadian", timeOpen2, timeClose2, true, 5, 40);
       
        Restaurant res1Reg3 = new Restaurant("Guisepi's","Saint John","Italian", timeOpen2, timeClose2, true, 5, 20);
        Restaurant res2Reg3 = new Restaurant("Jaque's","Saint John","French", timeOpen, timeClose, true, 5, -86);
        Restaurant res3Reg3 = new Restaurant("Ronald's","Saint John","American", timeOpen, timeClose, true, 5, 87.2);
       
        ArrayList<Restaurant> aLR1 = new ArrayList<Restaurant>();
        aLR1.add(res1Reg1);
        aLR1.add(res2Reg1);
        aLR1.add(res3Reg1);
        
        ArrayList<Restaurant> aLR2 = new ArrayList<Restaurant>();
        aLR2.add(res1Reg2);
        aLR2.add(res2Reg2);
        aLR2.add(res3Reg2);
        
        ArrayList<Restaurant> aLR3 = new ArrayList<Restaurant>();
        aLR3.add(res1Reg3);
        aLR3.add(res2Reg3);
        aLR3.add(res3Reg3);

        Coordinate co1 = new Coordinate(50.5,1);
        Coordinate co2 = new Coordinate(0,0);
        Coordinate co3 = new Coordinate(-10,-2);

        Region reg1 = new Region("Fredericton", co1, aLR1);
        Region reg2 = new Region("Moncton", co2, aLR2);
        Region reg3 = new Region("Saint John", co3, aLR3);
        ArrayList<Region> regions = new ArrayList<>();
        regions.add(reg1);
        regions.add(reg2);
        regions.add(reg3);
        regionList = new RegionList(regions);
    }

    public void startCustomerScreen(){
        currentScreen = "Customer";
        Main.view.setToInitialCustomerView();
    }

    public void restaurateurView(){
        currentScreen = "Restaurant";
        Main.view.setToRestaurateurView();
    }

    public void adminView(){
        currentScreen = "Admin";
        Main.view.setToAdminView();
    }

    public Region getCustomerRegion(String regionName){
        ArrayList<Region> regions = regionList.getRegionLst();
        for(int i = 0; i < regions.size(); i++){
            if(regions.get(i).getName().equals(regionName)){
                return regions.get(i);
            }
        }
        System.out.println("No Region Found Error");
        return null;
    }

    public void searchButton(){
        if(currentScreen.equals("Customer")){
            customer = new Customer(Main.view.getBudget(), getCustomerRegion(Main.view.getRegion()), Main.view.getFood());
            Main.view.setToCustomerSearchView();
        }else if(currentScreen.equals("Restaurant")){
            Restaurant newRestaurant = new Restaurant(Main.view.getName(), Main.view.getRegion(), Main.view.getFood(), Main.view.getOpenTime(), Main.view.getClosingTime(), Main.view.getDelivery(), 0, Main.view.getBudget());
            getCustomerRegion(Main.view.getRegion()).addRestaurant(newRestaurant);
        }
    }

    public void removeRestaurant(String name, String region){
        getCustomerRegion(region).removeRestaurant(name);
        adminView();
    }
}
