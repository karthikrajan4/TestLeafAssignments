package week1.day2.assignment;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "changeme";
		String output = "";
		char charArr[] = input.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			if (i % 2 == 0) {
				charArr[i] = Character.toUpperCase(charArr[i]);
				output = output + charArr[i];

			} else {
				output = output + charArr[i];
			}

		}
		System.out.println("The changed output is:" + output);
	}

}
