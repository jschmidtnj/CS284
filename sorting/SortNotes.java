package sorting;

public class SortNotes {

	/*
	 * Selection Sort
	 * move down array, finding min to the right and swapping
	 * |35 65 30 60 20 <- original
	 * 20 |65 30 60 35 // min was 20 // pass 1
	 * 20 30 |65 60 35 // min was 30 // pass 2
	 * 20 30 35 |60 65 // min was 35 // pass 3
	 * 20 30 35 60 |65 // min was 60 (no swap) // pass 4
	 * Now we're done
	 * 
	 * array has size n, n - 1 passes are performed
	 * 
	 * # pass        |  1   2   3  ... n - 1
	 * # comparisons | n-1 n-2 n-3 ...   1
	 * sum from i=1 to n-1 of i = n(n-1)/2
	 * O(n^2) = complexity
	 * O(n^2) = comparisons
	 * n-1 = # of swaps
	 */
	
	/*
	 * Bubble Sort
	 * swap adjacent elements that are out of order
	 * 60 42 75 83 27| <- original
	 * 42 60 75 83 27
	 * 42 60 75 83 27
	 * 42 60 75 83 27
	 * 42 60 75 27 |83 // end of pass 1
	 * 
	 * 42 60 27 |75 83 // end of pass 2
	 * 
	 * 42 27 |60 75 83 // end of pass 3
	 * 
	 * 27 |42 60 75 83 // end of pass 4
	 * Now we're done
	 * 
	 * n-1 passes
	 * 
	 * 1 2 3 4 5 takes 1 pass - takes 4 operations or n
	 * in selection sort takes n^2 still
	 * 
	 * 4 3 2 1 is worst case for bubble sort (4 + 3 + 2 + 1 swaps)
	 * n - 1 passes at most - just have a flag to check if any swaps were performed
	 * and if there were no swaps then you are done
	 * O(n^2)
	 */
}
