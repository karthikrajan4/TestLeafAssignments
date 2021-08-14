package week1.day2.assignment;

import java.util.Arrays;

//import org.apache.poi.util.SystemOutLogger;

public class MissingElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };

		Arrays.sort(arr);

		for (int i = 0; i <= arr.length; i++) {
			int diff = arr[i + 1] - arr[i];

			if (diff != 1) {
				System.out.println("The missing array element is:" + (arr[i] + 1));
				System.out.println("The missing array index is:" + arr[i]);
				break;
				
			}

		}
	}

}
