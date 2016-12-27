
/*
 * Alejandro Parana
 * CSCI300 Exercise 1.2
 * Date: 10/2014
 * Purpose: Exploring variable parameter lists.
 */
import java.util.Scanner;

public class Parameters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Calling avg() and min() methods using variable parameters
		double mean1, mean2, mean3, mean4;
		mean1 = avg(4, 5, 3);
		mean2 = avg(13);
		mean3 = avg();
		mean4 = avg(3, 16, 12, 9, 44, 21);

		int min1, min2, min3;
		min1 = min(2, 1000, -7);
		min2 = min();
		min3 = min(3, 5, 6, 1, 0, -55, 6);

		System.out.println("Mean: " + mean1 + ", " + mean2 + ", " + mean3 + ", " + mean4);
		System.out.println("Min: " + min1 + ", " + min2 + ", " + min3);

		// Input a sequence of numbers to process
		System.out.println("Enter up to 10 integers (-1 to quit): ");
		int index = 0;
		int[] list = new int[10];
		int num = in.nextInt();

		while (num >= 0 && index < 10) {
			list[index] = num;
			index++;
			num = in.nextInt();
		}
		// Copy list contents to get accurate results
		int[] properList = new int[index];
		for (int j = 0; j < index; j++) {
			properList[j] = list[j];
		}
		System.out.print("List: ");
		for (int i = 0; i < properList.length; i++) {
			System.out.print(properList[i] + " ");
		}
		System.out.println("\nList Average: " + avg(properList));
		System.out.println("List Minimum: " + min(properList));
	}

	/*
	 * AVG METHOD
	 * 
	 * @params (List of integers)
	 * 
	 * @returns (Double result)
	 */
	public static double avg(int... list) {
		double result = 0.0;
		if (list.length > 0) {
			int sum = 0;
			for (int num : list) {
				sum += num;
			}
			result = (double) sum / list.length;
		}
		return result;
	}

	/*
	 * MIN METHOD
	 * 
	 * @params (List of integers)
	 * 
	 * @returns (Int result)
	 */
	public static int min(int... list) {
		if (list.length == 0) {
			return 0;
		} else {
			int min = Integer.MAX_VALUE;
			for (int i : list) {
				if (i < min)
					min = i;
			}
			return min;
		}
	}
}
