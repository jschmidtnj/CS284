package sorting;

import java.util.Arrays;

public class Sorting {

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void selection(int[] a) {
		// swap with min elements
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
		// swap adjacent elements
		int n = a.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (a[j] > a[j + 1]) swap(a, j, j + 1);
	}
	
	public static void insertion(int[] a) {
		// find spot in list and insert there
		for (int nextPos = 1; nextPos < a.length; nextPos++) {
			int nextVal = a[nextPos];
			int current = nextPos;
			while(current - 1 >= 0 && a[current - 1] > nextVal) {
				a[current] = a[current - 1];
				current--;
			}
			a[current] = nextVal;
		}
	}
	
	private static int[] merge(int[] a, int[] b) {
		// O(n) or O(n + m)
		int[] c = new int[a.length + b.length];
		int indexa = 0;
		int indexb = 0;
		int indexc = 0;
		while (indexa < a.length && indexb < b.length) {
			if (a[indexa] < b[indexb]) {
				c[indexc] = a[indexa];
				indexa++;
			} else {
				c[indexc] = b[indexb];
				indexb++;
			}
			indexc++;
		}
		while (indexa < a.length) {
			c[indexc] = a[indexa];
			indexc++;
			indexa++;
		}
		while (indexb < b.length) {
			c[indexc] = b[indexb];
			indexc++;
			indexb++;
		}
		return c;
	}
		
	public static void mergesort(int[] a) {
		if (a.length <= 1)
			return;
		
		int size = a.length / 2;
		int[] left = Arrays.copyOfRange(a, 0, size);
		int[] right = Arrays.copyOfRange(a, size + 1, a.length);
		mergesort(left);
		mergesort(right);
		a = merge(left, right);
	}

	public static void main(String[] args) {
		int[] a = { 35, 65, 30, 60, 20 };
		System.out.println(Arrays.toString(a));
		selection(a);
		System.out.println(Arrays.toString(a));
		int[] b = { 35, 65, 30, 60, 20 };
		bubble(b);
		System.out.println(Arrays.toString(b));
		int[] c = { 35, 65, 30, 60, 20 };
		insertion(c);
		System.out.println(Arrays.toString(c));
		int[] d = { 35, 65, 30, 60, 20 };
		mergesort(d);
		System.out.println(Arrays.toString(d));
		
	}
}
