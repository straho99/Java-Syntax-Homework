package homework;

public class IntPoint {
	private int x;
	private int y;
	//these are the constructors:
	public IntPoint(int X, int Y) {
		this.x=X;
		this.y=Y;
	}
	public IntPoint() {
		this.x=0;
		this.y=0;
	}
	//these are the getters and setters for the two points:
	public int getX() {
		return this.x;
	}
	
	public void setX(int X) {
		this.x=X;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int Y) {
		this.y=Y;
	}
}
