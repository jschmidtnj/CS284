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
			// O(n*m) - worst case O(n^2) if they are the same size
			if (f(y, x[i]) == -1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean h(int[] x) {
		//checks if each value of i is unique
		//use table technique to show work:
		/*
		i | 0 1 2 3 4 5 6 ... n-1
		  | n n n n n n n ... n
		=> O(n^2)
		*/
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<x.length; j++) {
				if (i != j && x[i] == x[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void h1(int[] x) {
		//this is also n^2
		/*
		i | 0 1 2 3 4 5 6 ... n-1
		  | n n n n n n n ... n
		=> O(n^2)
		*/
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<x.length; j++) {
				System.out.println("hello");
			}
		}
	}
	
	public static void h2(int[] x) {
		//checks if each value of i is unique
		//use table technique to show work:
		/*
		i | 0 1 2 3 4 5 6 ... n-1
		  | 4 4 4 4 4 4 4 ... 4
		=> O(n) //4 gets consumed by big O, as is any integer - still linear growth rate, different running times for different ints
		*/
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<4; j++) {
				System.out.println("hello");
			}
		}
	}
	
	public static void k(int[] x) {
		//this is also n^2
		/*
		i | 0 1 2 3 4 5 6 ... n-1
		  | 0 1 2 3 4 5 6 ... n -1
		
		// The formula used below is well known - sum it up
		//sum from i=0 to n-1 of i = i*(i-1)/2 = i^2/2 - i/2 => i^2
		=> O(n^2)
		*/
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<i; j++) {
				System.out.println("hello");
			}
		}
	}
	
	public static boolean k1(int[] x) {
		//this is also n^2
		/*
		i | 0 1 2 3 4 5 6 ... n-1
		  | 0 1 2 3 4 5 6 ... n -1
		
		// The formula used below is well known - sum it up
		//sum from i=0 to n-1 of i = i*(i-1)/2 = i^2/2 - i/2 => i^2/2
		=> O(n^2)
		*/
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<i; j++) {
				if (i != j && x[i] == x[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void k2(int n) {
		/*
		iteration # | 0  1  2  3  4  5  6 ... n
		i           | 0  2  4  8 16 32 64 ... 2^n
		
		// 2^k < n <= 2^(k+1)
		// log2(2^k) < log2(n) <= log2(2^(k+1))
		// k < log2(n) <= k+1
		// k = |_ log2(n) _| //floor of that
		// O(log(n)) //can multiply to change base of log, so you can just drop the base
		=> O(n^2)
		*/
		for (int i=1; i<=n; i = i * 2) {
			System.out.println("hello");
		}
	}
	
	public static void m(int n) {
		//assume n > 1
		/*
		i | 1  2  3  4  5  6  7 ... n - 1
		j | 1  1  1  1  1  1  1 ... 1
		// iterations = (n - 1) * 1 = n
		// O(n)
		*/
		for (int i=1; i<n; i++) {
			for (int j=1; j<n; j = j * 2) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		System.out.println(f(arr1, 5));
		int[] arr2 = { 1, 2, 5 };
		System.out.println(g(arr2, arr1));
		//Time complexity of this code above is O(n*m)
		//n is length of x, m is length of y
		//checks for unique
		int[] arr3 = { 1, 3, 3, 5 };
		System.out.println(h(arr3));
		int[] arr4 = { 1, 3, 4, 5 };
		System.out.println(k1(arr4));
		int kcount = 2;
		k2(kcount);
	}
}
