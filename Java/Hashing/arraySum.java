/* --------------------------------------------------------
Given an array A[] of n numbers and another number x, 
determine whether or not there exist two elements in S whose
sum is exactly x. 
-------------------------------------------------------- */
import java.util.*;
public class arraySum {

	public static void pairSum(int[] array, int sum) {
		boolean[] binMap = new boolean[10000];
		int temp;		
		for (int i = 0; i < array.length; i++) {
			binMap[array[i]] = true;
			temp = sum - array[i];			
			if (temp<0) 
				temp = -1 * temp;			
			if (binMap[temp] == true && temp != array[i]) {
				System.out.println("["+array[i]+","+temp+"]");
			}			
		}		
	}


	// -------------------- MAIN --------------------
	public static void main(String[] args) {
		int[] array = {1, 4, 45, 6, 10, 8};
		int sum = 16;
		pairSum(array, sum);
	}
}