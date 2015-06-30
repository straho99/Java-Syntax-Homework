package homework;

import java.util.Scanner;

public class DecimalToHex {

	public static void main(String[] args) {
		// Problem 5:
		Scanner input=new Scanner(System.in);
		int number=input.nextInt();
		String hex = Integer.toHexString(number);
		System.out.println(hex.toUpperCase());
	}

}
