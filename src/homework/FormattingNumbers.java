package homework;

import java.util.Scanner;

public class FormattingNumbers {

	public static void main(String[] args) {
		// Problem 6:
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		double b = input.nextDouble();
		double c = input.nextDouble();

		String output = String.format("|%-10x", a); // Integer.toHexString(a).toUpperCase();
		output = output.toUpperCase();
		output = output
				+ "|"
				+ String.format("%10s", Integer.toBinaryString(a)).replace(' ',
						'0');
		output = output + "|" + String.format("%10.2f", b);
		output = output + "|" + String.format("%-10.3f", c);

		System.out.println(output);
	}

}
