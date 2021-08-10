package week1.day1.assignment;

public class KR_PrimeNumber {

	public static void main(String[] args) {
		int i = 14;
		boolean flag = false;
		for (int j = 2; j <= i / 2; j++) {
			if (i % j == 0) {
				flag = true;
			}
		}
		System.out.println("The given input is: " + i);
		if (!flag) {
			System.out.println("It a prime number");
		} else {
			System.out.println("It is not a prime number");
		}
	}
}
