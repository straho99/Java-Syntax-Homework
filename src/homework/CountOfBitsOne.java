package homework;

import java.util.Scanner;

public class CountOfBitsOne {

	public static void main(String[] args) {
		// Problem 7:
		Scanner input=new Scanner(System.in);
		int number=input.nextInt();
		int[] bits=DecimalToBinary(number);
		int count=0;
		for (int i = 0; i < bits.length; i++) {
			if (bits[i]==1) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	static int[] DecimalToBinary(int number)
    {
        int[] bits = new int[32];
        int i = 31;
        int remainder = number;
        int bit = 31;
        while (remainder > 0)
        {
            bit = remainder - (remainder / 2) * 2;
            remainder = remainder / 2;
            bits[i] = bit;
            i--;
        }

        return bits;
    }
}
