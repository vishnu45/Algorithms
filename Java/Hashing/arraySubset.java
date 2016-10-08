/* --------------------------------------------------------
Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether 
arr2[] is a subset of arr1[] or not. Both the arrays are not 
in sorted order. It may be assumed that elements in both array 
are distinct.
-------------------------------------------------------- */

import java.util.*;
public class arraySubset {

	public static boolean checkArrSub (int[] arr1, int[] arr2) {
		Hashtable<Integer, Integer> H1 = new Hashtable<Integer, Integer>();
		for (int i = 0; i < arr1.length; i++) {
			H1.put(arr1[i], arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			if (!H1.contains(arr2[i])) {
				return false;
			}
		}		
		return true;
	}

	public static void main(String[] args) {

		int[] arr1 = new int[] {11, 1, 13, 21, 3, 7};
		int[] arr2 = new int[] {11, 3, 7, 1};

		if (checkArrSub(arr1, arr2)) {
			System.out.println("arr2[] is a subset of arr1[]");
		}
		else {
			System.out.println("arr2[] is not a subset of arr1[]");
		}
	}
}