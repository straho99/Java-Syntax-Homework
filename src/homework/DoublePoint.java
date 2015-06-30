package homework;

public class DoublePoint {
	private double x;
	private double y;
	//these are the constructors:
	public DoublePoint(double X, double Y) {
		this.x=X;
		this.y=Y;
	}
	public DoublePoint() {
		this.x=0.0;
		this.y=0.0;
	}
	//these are the getters and setters for the two points:
	public double getX() {
		return this.x;
	}
	
	public void setX(double X) {
		this.x=X;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setY(double Y) {
		this.y=Y;
	}
}
