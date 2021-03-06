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
	
	/*
	 * Insertion sort
	 * create a new list and insert each element in the corresponding position
	 * 30 25 15 20 28
	 * []
	 * [30]; nextval = 25;
	 * [30, 30] -> [25, 30]; | 15 20 28 // shift over, then replace at index
	 * [15, 30, 30]; -> [15, 25, 30]; etc.
	 * 
	 * n -1  passes
	 * 
	 * worst case 54321 - has 1 2 3 and 4 shifts - corresponds to the pass $ -> n(n-1)/2 total
	 * O(n^2)
	 */
	
	/*
	 * Merge sort
	 * 
	 * 2 components - merge & mergesort
	 * merge takes two arrays and put them together - element by element adds the lowest element
	 * if the 2 arrays to merge are sorted, the result is sorted
	 * 
	 * split halfway, keep splitting recursively until they are singletons
	 * then compare and merge and pop
	 * 
	 * height is log2(n)
	 * O(nlogn)
	 */
	
	/*
	 * O(n^2) - selection, bubble, insertion
	 * O(nlogn) - merge
	 * O(n^1.5) - shell
	 * O(nlogn) - heap sort
	 * O(n^2) - quick sort
	 */
	
	/*
	 * heap sort
	 * create a heap, adding each element to heap & reheap, then remove from heap to get the order
	 * it's pretty straight-forward
	 * 
	 * add & remove used - both logn
	 * logn n times for both add and remove (2n*logn)
	 * 
	 * space complexity is large b/c you need to make a heap - useless
	 * so instead use the original array to make a heap.
	 */
	
	/*
	 * quick sort
	 * splits into 2 parts, sorts each part, puts it back together
	 * O(n^2logn) for just using the pivot as the first element and putting lesser to left,
	 * greater to right, then do recursive
	 * 
	 * but if you have an up and a down pointer as well, and you check while a[up] < a[pivot] && up < last do the
	 * swapping
	 * 
	 * this reduces it to O(n) time
	 * 
	 * you have an up and a down and a pivot
	 * all elements that are smaller than the pivot go to the left of the pivot.
	 */
}
