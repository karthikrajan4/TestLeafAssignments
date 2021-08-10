package week1.day1.assignment;

import org.apache.poi.util.SystemOutLogger;

public class KR_Amstrong {

	public static void main(String[] args) {
		int i = 153;
		int calculated;
		int reminder;
		int original = 0;
		int quotient;
		int input = i;
			while (i>0) {
				reminder = i%10;
				quotient = i/10;
				i = quotient;
				calculated = reminder*reminder*reminder;
				original = original+calculated;
			}
			System.out.println("The input number is: " + input);
			System.out.println("The final number is: " + original);
			
			if (input==original) {
				System.out.println("Given number is amstrong");
			}
			else {
				System.out.println("Given number is not an amstrong");
			}
	}

}
