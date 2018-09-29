package homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDLListTest {

	@Test
	void test() {
		IDLList<Integer> l1 = new IDLList<Integer>();
		l1.add(3);
		assertEquals(l1.toString(), "[3]");
		l1.add(4);
		assertEquals(l1.toString(), "[4,3]");
		assertEquals(l1.size(), 2);
		assertEquals(l1.remove() == 4, true);
		assertEquals(l1.getHead() == 3, true);
		assertEquals(l1.getLast() == 3, true);
	}

}
