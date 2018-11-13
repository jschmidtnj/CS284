package homework6;

import java.util.Stack;
import java.util.Arrays;

/**
 * For this assignment, you will implement Lamport’s iterative (non-recursive)
 * variant of Hoare’s quicksort sorting algorithm in Java.
 * 
 * @author Joshua Schmidt
 *
 * @param <T> generic comparable for sorting
 */
public class Sort<T extends Comparable<T>> {

	private static class Interval {

		// Data Fields

		private int lower;
		private int upper;

		// Constuctor

		public Interval(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}

		// Methods

		/**
		 * gets lower bound data point
		 * @return the lower bound
		 */
		public int getLower() {
			return lower;
		}

		/**
		 * gets upper bound data point
		 * @return the upper bound
		 */
		public int getUpper() {
			return upper;
		}

		/**
		 * checks if 2 intervals are equal
		 * @return true if this interval and the given interval have the same lower and
		 *         upper bounds
		 */
		public boolean equals(Object o) {
			Interval testinterval;
			try {
				testinterval = (Interval) o;
			} catch (Exception ClassCastException) {
				throw new IllegalArgumentException("object cannot be cast to Interval");
			}
			return testinterval.lower == this.lower && testinterval.upper == this.upper;
		}

		/**
		 * returns the hash code of the interval
		 * @return lower * lower + upper
		 */
		public int hashCode() {
			return lower * lower + upper;
		}
	}

	/**
	 * swaps elements in a array at indexes i and j
	 * @param a array
	 * @param i first index to swap
	 * @param j second index to swap
	 */
	private static <T> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * sorts array of generics using Lamport’s iterative quicksort and median of 3
	 * to get the pivot point
	 * @param array
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {

		if ((array == null) || (array.length < 2)) {
			return;
		}

		// create stack of intervals
		Stack<Interval> intervals = new Stack<Interval>();

		// start with interval at full len
		intervals.add(new Interval(0, array.length - 1));

		while (!intervals.isEmpty()) {
			Interval current = intervals.pop();
			int high = current.getUpper();
			int low = current.getLower();
			int span = high - low;

			// could use assert
			if (!((low >= 0) && (low < array.length)))
				break;
			if (!((high >= 0) && (high < array.length)))
				break;
			if (!(low <= high))
				break;

			if (span >= 2) {
				// pivot index is lowest, pivot is highest element
				int pivotIndex = low;
				T pivot = array[high];

				// look at all elements and if element is smaller swap and increment pivot index
				for (int i = low; i < high; i++) {
					if (array[i].compareTo(pivot) < 0) {
						swap(array, pivotIndex, i);
						pivotIndex++;
					}
				}
				// Swap the pivot and the high
				swap(array, pivotIndex, high);

				// Create the next 2 intervals (low and high) - median
				Interval lowPart = new Interval(low, Math.max(low, pivotIndex - 1));
				Interval highPart = new Interval(Math.min(pivotIndex + 1, high), high);
				// add indexes to median
				intervals.add(lowPart);
				intervals.add(highPart);
			} else if (span == 1) {
				if (array[low].compareTo(array[high]) > 0) {
					swap(array, low, high);
				}
			}
			// otherwise only 1 element in Interval so do nothing
		}
	}

	public static void main(String[] args) {
		Integer[] t1 = new Integer[5];
		t1[0] = 6;
		t1[1] = 3;
		t1[2] = 4;
		t1[3] = 1;
		t1[4] = 2;
		System.out.println(Arrays.toString(t1));
		sort(t1);
		System.out.println(Arrays.toString(t1));

	}

}
