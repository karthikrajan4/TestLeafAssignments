package week1.day2.assignment;

import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) {
		int[] data = { 3, 2, 11, 4, 6, 7 };
		Arrays.sort(data);
		int dataLength = data.length;

		// ArrayLength = Array's Last index + 1
		// So I am taking the second largest value from the Array last index using length
		
		System.out.println("The second largest element in this array is:" + data[dataLength - 2]);
	}

}
