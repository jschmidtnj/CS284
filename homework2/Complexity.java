package homework2;

public class Complexity {
	public static void method0(int n) {
		// O(n) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	public static void method1(int n) {
		// O(n^2) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	public static void method2(int n) {
		// O(log(n)) complexity
		int counter = 0;
		for (int i = 1; i < n; i *= 2) {
			System.out.println(" Operation " + counter);
			counter++;
		}
	}

	public static void method3(int n) {
		// O(n*log(n)) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j *= 2) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	public static void method4(int n) {
		// O(n^3) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.println("Operation " + counter);
					counter++;
				}
			}
		}
	}

	public static void method5(int n) {
		// O(log(log(n)))
		int counter = 0;
		for (int i = n; i > 1; i = (int) Math.sqrt(i)) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	public static int method6(int n) {
		// O(2^n) complexity
		if (n <= 0) {
			return 0;
		} else {
			return 1 + method6(n - 1) + method6(n - 1);
		}
	}
}
