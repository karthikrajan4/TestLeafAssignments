package week3.day2.assignment;

import java.util.*;

public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<String>();

		a1.add("CTS");
		a1.add("HCL");
		a1.add("Aspire Systems");
		a1.add("Wipro");

		Collections.sort(a1);
		System.out.println("The Sorted Array value is:" + a1);

		Collections.sort(a1, Collections.reverseOrder());
		System.out.println("The Reverse Sorted Array value is:" + a1);
	}

}
