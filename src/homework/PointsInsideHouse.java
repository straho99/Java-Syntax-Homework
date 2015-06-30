package homework;

import java.util.Scanner;

public class PointsInsideHouse {
	public static void main(String[] args) {
		// Problem 9:
		Scanner input = new Scanner(System.in);
		 DoublePoint point = new DoublePoint(input.nextDouble(),
				 input.nextDouble());
		boolean inside = false;

		//DoublePoint point = new DoublePoint(22.5,8.5);

		//System.out.println(IsInsideRoof(point));

		 inside = IsInsideRoof(point) ||
			PointsInsideFigure.IsInsideLeft(point)
		 	|| PointsInsideFigure.IsInsideRight(point);
		 if (inside) {
		 System.out.println("Inside");
		 } else {
		 System.out.println("Outside");
		 }
	}
	
	public static boolean isInsideHouse(DoublePoint point) {
		boolean inside=false;
		inside = IsInsideRoof(point) ||
				PointsInsideFigure.IsInsideLeft(point)
			 	|| PointsInsideFigure.IsInsideRight(point);
		return inside;
	}

	public static boolean IsInsideRoof(DoublePoint point) {
		boolean inside = false;
		DoublePoint a = new DoublePoint(12.5, 8.5);
		DoublePoint b = new DoublePoint(17.5, 3.5);
		DoublePoint c = new DoublePoint(22.5, 8.5);
		double leftSidePosition = BelowLine(point, a, b);
		double rightSidePosition = BelowLine(point, b, c);
		if (leftSidePosition >=0 && rightSidePosition >= 0 && point.getY() <= 8.5) {
			inside = true;
		}

		return inside;
	}

	// method to check if a point is bellow or above a line, defined by another
	// two points.
	// returns positive, zero or negative value depending on the point location
	// compared to the line and the inclination of the line
	public static double BelowLine(DoublePoint point, DoublePoint a,
			DoublePoint b) {
		double result = (b.getX() - a.getX()) * (point.getY() - a.getY());
		result = result - (b.getY() - a.getY()) * (point.getX() - a.getX());
//		System.out.println(result);
		return result;
	}
}
