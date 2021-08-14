package week1.day2.assignment;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator calc = new Calculator();

		int addi = calc.add(1, 2, 3);
		System.out.println("Given addition value is:" + addi);

		int subtract = calc.sub(4, 5);
		System.out.println("Given subtraction value is:" + subtract);

		double multiply = calc.mul(6, 7);
		System.out.println("Given multiplication value is:" + multiply);

		float divide = calc.div(8, 9);
		System.out.println("Given division value is:" + divide);

	}

}
