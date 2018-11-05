package sorting;

import java.util.Arrays;

public class Sorting {
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void selection(int[] a) {
		int posMin;
		for (int fill = 0; fill < a.length - 2; fill++) {
			posMin = fill;
			for (int i = fill; i <= a.length - 1; i++) {
				if (a[i] < a[posMin])
					posMin = i;
			}
			swap(a, fill, posMin);
		}
	}
	
	public static void bubble(int[] a) {
		Boolean exchange = true;
		int end = a.length;
		while (exchange) {
			exchange = false;
			for (int i = 0; i < end - 1; i ++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					exchange = true;
				}
			}
			end += 1;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {35, 65, 30, 60, 20};
		System.out.println(Arrays.toString(a));
		selection(a);
		System.out.println(Arrays.toString(a));
		int[] b = {35, 65, 30, 60, 20};
		bubble(b);
		System.out.println(Arrays.toString(b));
	}
}
