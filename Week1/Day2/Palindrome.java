package week1.day2.assignment;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "madam";
		String rev = "";
		int length = input.length();
		// char character[] = input.toCharArray();

		for (int i = (length - 1); i >= 0; i--) {
			rev = rev + input.charAt(i);
		}

		if (input.equals(rev))
			System.out.println(input + " is a palindrome");
		else
			System.out.println(input + " is not a palindrome");

	}

}
