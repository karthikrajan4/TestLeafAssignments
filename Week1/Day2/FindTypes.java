package week1.day2.assignment;

public class FindTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int letter = 0, space = 0, num = 0, specialChar = 0;

		char[] charArr = test.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (Character.isLetter(charArr[i]))
				letter = letter + 1;
			else if (Character.isDigit(charArr[i]))
				num = num + 1;
			else if (Character.isSpaceChar(charArr[i]))
				space = space + 1;
			else
				specialChar = specialChar + 1;
		}

		System.out.println("Letters: " + letter);
		System.out.println("Digits: " + num);
		System.out.println("Spaces: " + space);
		System.out.println("Special characters: " + specialChar);
	}

}
