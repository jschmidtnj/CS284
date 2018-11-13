package homework6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortTest {

	@Test
	void test() {
		Integer[] t1 = {6, 3, 4, 1, 2};
		// System.out.println(Arrays.toString(t1));
		Sort.sort(t1);
		// System.out.println(Arrays.toString(t1));
		Integer[] t1sorted = {1, 2, 3, 4, 6};
		assertEquals(Arrays.equals(t1, t1sorted), true);

		Integer[] t2 = {9, -1, 7, 3, 5};
		// System.out.println(Arrays.toString(t2));
		Sort.sort(t2);
		// System.out.println(Arrays.toString(t2));
		Integer[] t2sorted = {-1, 3, 5, 7, 9};
		assertEquals(Arrays.equals(t2, t2sorted), true);
		
		Integer[] t3 = {-41, 30, 2, 100, 99, 2};
		// System.out.println(Arrays.toString(t3));
		Sort.sort(t3);
		// System.out.println(Arrays.toString(t3));
		Integer[] t3sorted = {-41, 2, 2, 30, 99, 100};
		assertEquals(Arrays.equals(t3, t3sorted), true);
	}

}
