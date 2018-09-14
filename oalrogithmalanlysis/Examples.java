package oalrogithmalanlysis;

public class Examples {
	public void method1(int n) {
		//O(n)
		for (int i=0; i<n; i++) {
			System.out.println("test");
		}
	}
	public void method2(int n) {
		//O(n^2)
		for (int i=0; i < n; i++) {
			for (int j=0; j<n; j++) {
				System.out.println("test");
			}
		}
	}
	public void method3(int n) {
		//O(1)
		for (int i=0; i < n; i++) {
			System.out.println("test");
			break;
		}
	}
	public void method4(int n) {
		//O(n^2) still
		//n(n-5)
		//n^2-5n
		for (int i=0; i < n; i++) {
			for (int j=5; j<n; j++) {
				System.out.println("test");
			}
		}
	}
	public void method5(int n) {
		//O(n^2)
		//n*(n/2) = n^2/2
		for (int i=0; i < n; i++) {
			for (int j=0; j<n; j+=2) {
				System.out.println("test");
			}
		}
	}
	public void method6(int n) {
		//O(n*log(n))
		//log base 2
		//n*log(n)
		for (int i=0; i < n; i++) {
			//starts at 1 - this gives it away (also increment is *)
			for (int j=1; j<n; j*=2) {
				System.out.println("test");
			}
		}
	}
	public void method7(int n) {
		//O(n)
		//time is 3n
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
	}
	public void method8(int n) {
		//O(n^2)
		//time is n + n^2
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
		for (int i=0; i < n; i++) {
			for (int k=n; k > 0; k--) {
				System.out.println("test");
			}
		}
	}
}
