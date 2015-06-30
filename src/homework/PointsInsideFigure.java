package homework;

import java.util.Scanner;

public class PointsInsideFigure {

	public static void main(String[] args) {
		// Problem 3 from homework
		Scanner input = new Scanner(System.in);
		DoublePoint point = new DoublePoint(input.nextDouble(),
				input.nextDouble());
		boolean inside = false;
		inside = IsInsideTop(point) || IsInsideLeft(point)
				|| IsInsideRight(point);
		if (inside) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}

	public static boolean IsInsideTop(DoublePoint point) {
		boolean inside = true;
		if (point.getX() < 12.5 || point.getX() > 22.5) {
			inside = false;
		}
		if (point.getY() < 6 || point.getY() > 8.5) {
			inside = false;
		}
		return inside;
	}

	public static boolean IsInsideLeft(DoublePoint point) {
		boolean inside = true;
		if (point.getX() < 12.5 || point.getX() > 17.5) {
			inside = false;
		}
		if (point.getY() < 8.5 || point.getY() > 13.5) {
			inside = false;
		}
		return inside;
	}

	public static boolean IsInsideRight(DoublePoint point) {
		boolean inside = true;
		if (point.getX() < 20 || point.getX() > 22.5) {
			inside = false;
		}
		if (point.getY() < 8.5 || point.getY() > 13.5) {
			inside = false;
		}
		return inside;
	}
}
