package test1;

public class TestNotes {
	
	//Time Complexity - determine time complexity on a snippet of code
	//Linked list - programming exercise (1 or 2) - maybe double linked.
	//Stacks - very similar to queues - an exercise on one of the two
	//Queues
	
	//may have combinations of data structures
	//no recursion (done with it for now)
	
	//do exercise booklets - questions taken from past midterms
	
	//TIme Complexity
	
	public void complexity1(int n) {
		/*
		 * Table -> T(n) -> O(n)
		 * i        0 1 2 3 ... n-1
		 * # iter   0 1 2 3 ... n-1
		 * O(n) = n^2
		 */
		for (int i=0; i<n; i++) {
			for (int j=i; j>0; j--) {
				System.out.println("hello");
			}
		}
	}
	
	public void complexity2(int n) {
		/*
		 * Table -> T(n) -> O(n)
		 * i        0 1 2 3 ... n-1
		 * # iter   0 1 2 3 ... n-1
		 * T(n) = sum i=1 to n-1 of i*2 => T(n) = n^2-n
		 * O(n) = n^2
		 */
		for (int i=0; i<n; i++) {
			for (int j=i; j>0; j--) {
				//this counts as 2 units of time
				System.out.println("hello");
				System.out.println("bye");
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
