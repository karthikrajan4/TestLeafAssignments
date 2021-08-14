package week1.day2.assignment;

import java.util.Arrays;

public class PrintDuplicatesInAr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		Arrays.sort(arr);
		for(int i=0; i<arr.length-1;i++){
			if(arr[i]-arr[i+1] == 0) {
				System.out.println("The duplicate values are:" + arr[i]);
			}
		}

	}

}
