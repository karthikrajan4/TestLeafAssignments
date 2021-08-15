package week1.day2.assignment;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input1 = "stops";
		String input2 = "potss";

		if (input1.length() == input2.length()) {
			char[] charArr1 = input1.toCharArray();
			char[] charArr2 = input2.toCharArray();
			Arrays.sort(charArr1);
			Arrays.sort(charArr2);

			input1 = String.valueOf(charArr1);
			input2 = String.valueOf(charArr2);
			if (input1.equalsIgnoreCase(input2))
				System.out.println("Both the input strings are Anagram");
			else
				System.out.println("Both the input strings are not Anagram");
		}

	}

}
