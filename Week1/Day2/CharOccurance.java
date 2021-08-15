package week1.day2.assignment;

public class CharOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "welcome to chennai";
		int count = 0;
		char[] charArr = input.toCharArray();
		int length = charArr.length;

		for (int i = 0; i < length; i++)
			if (charArr[i] == 'c')
				count = count + 1;

		System.out.println("No. of occurances of 'c' is : " + count);


	}

}
