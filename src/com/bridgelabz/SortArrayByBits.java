package com.bridgelabz;

import java.util.Arrays;

public class SortArrayByBits {
	public int[] sortByBits(int[] arr) {
		int n = arr.length;
		int[] bitCounts = new int[n];
		for (int i = 0; i < n; i++) {
			int x = arr[i];
			int count = 0;
			while (x != 0) {
				if ((x & 1) == 1) {
					count++;
				}
				x >>= 1;
			}
			bitCounts[i] = count;
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (bitCounts[i] > bitCounts[j] || (bitCounts[i] == bitCounts[j] && arr[i] > arr[j])) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					temp = bitCounts[i];
					bitCounts[i] = bitCounts[j];
					bitCounts[j] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		SortArrayByBits sortArray1 = new SortArrayByBits();
		System.out.println(Arrays.toString(sortArray1.sortByBits(arr1)));

		int[] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
		SortArrayByBits sortArray2 = new SortArrayByBits();
		System.out.println(Arrays.toString(sortArray2.sortByBits(arr2)));


	}
}


