package project.g7;

public class Coordinate {
	private double x;
	private double y;
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getDistance(Coordinate other) {
		double distanceX = x - other.x;
		double distanceY = y - other.y;
		
		return Math.sqrt((Math.pow(distanceX, 2)) + (Math.pow(distanceY, 2)));
	}
}
