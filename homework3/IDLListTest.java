package homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDLListTest {

	IDLList<Integer> l1 = new IDLList<Integer>();
	@Test
	void test() {
		l1.add(10);
		assertEquals(l1.toString(), "[10]");
		assertEquals(true, true);
	}

}
