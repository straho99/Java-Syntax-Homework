package homework;

import java.util.Scanner;

public class CountOfBitPairs {
	public static void main(String[] args) {
		// Problem :
		Scanner input=new Scanner(System.in);
		int number=input.nextInt();
		String bits=Integer.toBinaryString(number);
		int count=0;
		for (int i = 1; i < bits.length(); i++) {
			if (bits.charAt(i)==bits.charAt(i-1)) {
				count++;
			}
		}
		System.out.println(count);
	}	
}
