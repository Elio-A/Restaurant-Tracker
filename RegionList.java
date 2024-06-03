package project.g7;

import java.util.ArrayList;

public class RegionList{
	private ArrayList<Region> regionLst;

	public RegionList(ArrayList<Region> regionLst){
		this.regionLst = regionLst;
	}
	
	public ArrayList<Region> getRegionLst(){ return regionLst; }
	
	public void setRegionLst(ArrayList<Region> regionLst){
		this.regionLst = regionLst;
	}
	
	public ArrayList<Restaurant> getFullOrderedRestaurantList(Customer client){
		Region currentRegion = null;
		ArrayList<Region> remainingRegionLst = new ArrayList<Region>();
		ArrayList<Restaurant> restaurantResultList = new ArrayList<Restaurant>();
		
		for(int i=0; i<regionLst.size(); i++){
			if((regionLst.get(i)).equals(client.getRegion())){
				currentRegion = regionLst.get(i);
			}
			else{
				remainingRegionLst.add(regionLst.get(i));
			}
		}
		
		if(currentRegion != null){
			restaurantResultList = currentRegion.getOrderedRestaurantList(client);
		}
		
		if(restaurantResultList.isEmpty()){
			remainingRegionLst = orderRegionList(client, remainingRegionLst);
			for(int i=0; i<remainingRegionLst.size() && restaurantResultList.isEmpty(); i++){
				currentRegion = remainingRegionLst.get(i);
				restaurantResultList = currentRegion.getOrderedRestaurantList(client);
			}
		}
		
		return restaurantResultList;
	}
	
	private ArrayList<Region> orderRegionList(Customer client, ArrayList<Region> regionListRemaining){
		Region temp;
		int min;
		
		for(int outer = 0; outer < regionListRemaining.size()-1; outer++){
			min = outer;
			for(int inner = outer+1; inner<regionListRemaining.size(); inner++){
				Coordinate coordInner;
				Coordinate coordClient;
				Coordinate coordMin;
				
				coordClient = (client.getRegion()).getCoordinate();
				coordInner = (regionListRemaining.get(inner)).getCoordinate();
				coordMin = (regionListRemaining.get(min)).getCoordinate();
				
				if(coordInner.getDistance(coordClient) < coordMin.getDistance(coordClient)){
					min = inner;
				}
			}
			temp = regionListRemaining.get(outer);
			regionListRemaining.set(outer, regionListRemaining.get(min));
			regionListRemaining.set(min, temp);
		}
		
		return regionListRemaining;
	}	
}
