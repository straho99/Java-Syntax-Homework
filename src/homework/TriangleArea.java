package homework;

import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {
		// Problem 02 from homework
		Scanner input = new Scanner(System.in);
		IntPoint[] points = new IntPoint[3];
		for (int i = 0; i < 3; i++) {
			points[i] = new IntPoint(input.nextInt(), input.nextInt());
			input.nextLine();
		}
		double area = CalculateTriangleArea(points[0], points[1], points[2]);
		System.out.println((int) area);
	}

	public static double CalculateTriangleArea(IntPoint a, IntPoint b,
			IntPoint c) {
		double area = 0;
		area = a.getX() * (b.getY() - c.getY());
		area = area + b.getX() * (c.getY() - a.getY());
		area = area + c.getX() * (a.getY() - b.getY());
		area = area / 2;
		area = Math.abs(area);
		return area;
	}

}
