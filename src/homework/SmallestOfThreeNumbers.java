package homework;

import java.util.Scanner;

public class SmallestOfThreeNumbers {

	public static void main(String[] args) {
		// Problem 4 from homework
		Scanner input=new Scanner(System.in);
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		double min=min(a,b,c);
		System.out.println(min);

	}
	public static double min(double a, double b, double c) {
	    return Math.min(Math.min(a, b), c);
	}
}
