package project.g7;

import java.time.LocalTime;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Restaurant {
	private final SimpleStringProperty restaurantName;
	private final SimpleStringProperty regionName;
	private final SimpleStringProperty foodType;
	private LocalTime openHours;
	private LocalTime closeHours;
	private final SimpleBooleanProperty deliveryOption;
	private final SimpleDoubleProperty rating;
	private final SimpleDoubleProperty averagePrice;
	private final SimpleBooleanProperty activeStatus = new SimpleBooleanProperty(true);
	
	public Restaurant(String nameIn,String regionNameIn,String foodTypeIn, LocalTime openHoursIn, LocalTime closeHoursIn, 
		boolean deliveryIn, double ratingIn, double averagePriceIn) {
		restaurantName = new SimpleStringProperty(nameIn);
		regionName = new SimpleStringProperty(regionNameIn);
		foodType = new SimpleStringProperty(foodTypeIn);
		openHours = openHoursIn;
		closeHours = closeHoursIn;
		deliveryOption = new SimpleBooleanProperty(deliveryIn);
		rating = new SimpleDoubleProperty(ratingIn);
		averagePrice = new SimpleDoubleProperty(averagePriceIn);
	}
	
	public String getRestaurantName() { return restaurantName.get(); }
	public String getRegionName() { return regionName.get(); }
	public String getFoodType() { return foodType.get(); }
	public LocalTime getOpenHours() { return openHours; }
	public LocalTime getCloseHours() { return closeHours; }
	public boolean getDeliveryOption() { return deliveryOption.get(); }
	public double getRating() { return rating.get(); }
	public double getAveragePrice() { return averagePrice.get(); }
	public boolean getActiveStatus() { return activeStatus.get(); }
	
	public void setFoodType(String foodType) { this.foodType.set(foodType); }
	public void setOpeningHours(LocalTime openHours) { this.openHours = openHours; }
	public void setClosingHours(LocalTime closeHours) { this.closeHours = closeHours; }
	public void setRating(double rating) { this.rating.set(rating); }
	public void setAveragePrice(double averagePrice) { this.averagePrice.set(averagePrice); }
	public void setActiveStatus(boolean newStatus) { this.activeStatus.set(newStatus); }
}
