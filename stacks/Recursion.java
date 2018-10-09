package stacks;

public class Recursion {
	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fact(n-1);
	}
	
	public static double facttr(int n, double acc) {
		if (n <= 1) {
			return 1;
		}
		return facttr(n-1, n * acc);
	}
	
	public static double fib(double n) {
		//O(2^n)
		if (n <= 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static double ffib(double n, double current, double old) {
		//O(n)
		if (n<= 1) {
			return current;
		}
		return ffib(n-1, current+old, current);
	}
	
	public static double ffib(double n) {
		return ffib(n, 1, 1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(ffib(50));
	}
}
