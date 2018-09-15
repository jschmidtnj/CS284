package homework2;

import java.lang.Math;

public class TestComplexity {
	public static void main(String[] args) {
		int pausedelay = 100; // milliseconds
		System.out.println("method 0");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth0 = 3;
		Complexity.method0(nummeth0);
		System.out.print("n for method 0: ");
		System.out.println(nummeth0);
		System.out.println("method 1");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth1 = 3;
		Complexity.method1(nummeth1);
		System.out.print("n^2 for method 1: ");
		System.out.println(Math.pow(nummeth1, 2));
		System.out.println("method 2");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth2 = 15;
		Complexity.method2(nummeth2);
		System.out.print("log(n) for method 2: ");
		System.out.println(Math.log(nummeth2) / Math.log(2));
		System.out.println("method 3");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth3 = 10;
		Complexity.method3(nummeth3);
		System.out.print("n*log(n) for method 3: ");
		System.out.println(nummeth3 * (Math.log(nummeth3) / Math.log(2)));
		System.out.println("method 4");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth4 = 3;
		Complexity.method4(nummeth4);
		System.out.print("n^3 for method 4: ");
		System.out.println(Math.pow(nummeth4, 3));
		System.out.println("method 5");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth5 = 10;
		Complexity.method5(nummeth5);
		System.out.print("log(log(n)) for method 5: ");
		System.out.println(Math.log(Math.log(nummeth5) / Math.log(2)) / Math.log(2));
		System.out.println("method 6");
		try {
			Thread.sleep(pausedelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nummeth6 = 10;
		System.out.println(Complexity.method6(nummeth6));
		System.out.print("2^n for method 6: ");
		System.out.println(Math.pow(2, nummeth6));
	}
}
