package oalrogithmalanlysis;

public class GrowthRates {
	public static int f(int[] x, int target) {
		// constant time operation - takes one theoretical unit of time (1 O)
		for (int i = 0; i < x.length; i++) {
			// constant unit of time 1 per loop - therefore worst case big O is O(n) ->
			// linear
			// Big O notation is all about growth rate - how the running time grows with the
			// growth of the array size
			// a ratio - a proportion - a relative amount
			if (x[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static boolean g(int[] x, int[] y) {
		// checks whether x is found within y
		for (int i = 0; i < x.length; i++) {
			// worst case loops x.length times (time n)
			// and loops over in f() - y.length times at worse (time m)
			// O(n*m) - worst case O(n^2)
			if (f(y, x[i]) == -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		System.out.println(f(arr1, 5));
		int[] arr2 = { 1, 2, 3, 5 };
		System.out.println(g(arr2, arr1));
	}
}
