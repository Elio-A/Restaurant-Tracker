package project.g7;

import java.util.ArrayList;
import java.time.LocalTime;

public class Region{
	private String name;
	private Coordinate coordinate;
	private ArrayList<Restaurant> restaurantList;
	
	public Region(String name, Coordinate coordinate, ArrayList<Restaurant> restaurantList){
		this.name = name;
		this.coordinate = coordinate;
		this.restaurantList = restaurantList;
	}

	public ArrayList<Restaurant> getRestaurants(){ return restaurantList; }

	public void addRestaurant(Restaurant restaurant){ restaurantList.add(restaurant); }

	public void removeRestaurant(String name){
		for(int i = 0; i < restaurantList.size(); i++){
			if(restaurantList.get(i).getRestaurantName().equals(name)){
				restaurantList.remove(i);
				return;
			}
		}
	}
	
	private ArrayList<Restaurant> orderRestaurantList(Customer client){
		ArrayList<Restaurant> resultRestaurantList = new ArrayList<Restaurant>();
		ArrayList<Restaurant> remainingRestaurantList = new ArrayList<Restaurant>();
		LocalTime time = LocalTime.now();
		int min;
		Restaurant temp;
		
		for(int i=0; i<restaurantList.size(); i++){
			Restaurant currentRestaurant = restaurantList.get(i);
			
			if((client.getFoodPreference()).equals(currentRestaurant.getFoodType())){
				if(time.isBefore(currentRestaurant.getCloseHours()) && time.isAfter(currentRestaurant.getOpenHours()) && currentRestaurant.getActiveStatus()){
					resultRestaurantList.add(currentRestaurant);
				}
			}
			else{
				remainingRestaurantList.add(currentRestaurant);
			}
		}
		
		if(resultRestaurantList.isEmpty()){
			for (int i=0; i<remainingRestaurantList.size(); i++){
				Restaurant currentRestaurant = remainingRestaurantList.get(i);
				
				if(time.isBefore(currentRestaurant.getCloseHours()) && time.isAfter(currentRestaurant.getOpenHours()) && currentRestaurant.getActiveStatus()){
					resultRestaurantList.add(currentRestaurant);
				}
			}
		}

		for(int outer = 0; outer < resultRestaurantList.size()-1; outer++){
			min = outer;
			for(int inner = outer+1; inner<resultRestaurantList.size(); inner++){
				if(Math.abs(resultRestaurantList.get(inner).getAveragePrice() - client.getBudget()) < Math.abs(resultRestaurantList.get(min).getAveragePrice() - client.getBudget())){
					min = inner;
				}
			}
			temp = resultRestaurantList.get(outer);
			resultRestaurantList.set(outer, resultRestaurantList.get(min));
			resultRestaurantList.set(min, temp);
		}
		
		return resultRestaurantList;
	}
	
	public String getName(){
		return name;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public ArrayList<Restaurant> getOrderedRestaurantList(Customer client){
		return this.orderRestaurantList(client);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void setRestaurantList(ArrayList<Restaurant> restaurantList){
		this.restaurantList = restaurantList;
	}
}
