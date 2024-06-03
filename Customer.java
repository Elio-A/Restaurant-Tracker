package project.g7;

public class Customer {
	private double budget;
	private Region currentRegion;
	private String foodPreference;
	
	public Customer(double budget, Region currentRegion, String foodPreference) {
		this.budget = budget;
		this.currentRegion = currentRegion;
		this.foodPreference = foodPreference;
	}
	
	public boolean setBudget(double budget) {
		boolean success = false;
		
		if (budget > 0) {
			success = true;
			this.budget = budget;
		}
		
		return success;
	}
	
	public void setRegion(Region currentRegion) {
		this.currentRegion = currentRegion;
	}
	
	public void setFoodPreference(String foodPreference) {
		this.foodPreference = foodPreference;
	}
	
	public double getBudget() {
		return budget;
	}
	
	public Region getRegion() {
		return currentRegion;
	}
	
	public String getFoodPreference() {
		return foodPreference;
	}
}
