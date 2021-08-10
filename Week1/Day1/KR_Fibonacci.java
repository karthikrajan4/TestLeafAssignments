package week1.day1.assignment;

public class KR_Fibonacci {

	public static void main(String[] args) {

		int range = 7;
		int input = 0;
		int j = 1;
		int sum = 1;
		System.out.println(input);
		for (int k = 1; k < range; k++) {
			System.out.println(sum);
			sum = input + j;
			input = j;
			j = sum;
		}

	}

}
