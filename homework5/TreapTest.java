package homework5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreapTest {

	@Test
	void test() {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		assertEquals(testTree.toString(), "(key=4, priority=19)\n" + 
				"  null\n" + 
				"  null");
		testTree.add(2, 31);
		assertEquals(testTree.toString(), "(key=2, priority=31)\n" + 
				"  null\n" + 
				"  (key=4, priority=19)\n" + 
				"    null\n" + 
				"    null");
		testTree.add(6, 70);
		assertEquals(testTree.toString(), "(key=6, priority=70)\n" + 
				"  (key=2, priority=31)\n" + 
				"    null\n" + 
				"    (key=4, priority=19)\n" + 
				"      null\n" + 
				"      null\n" + 
				"  null");
		testTree.add(1, 84);
		assertEquals(testTree.toString(), "(key=1, priority=84)\n" + 
				"  null\n" + 
				"  (key=6, priority=70)\n" + 
				"    (key=2, priority=31)\n" + 
				"      null\n" + 
				"      (key=4, priority=19)\n" + 
				"        null\n" + 
				"        null\n" + 
				"    null");
		assertEquals(testTree.add(3, 12), true);
		assertEquals(testTree.add(3, 15), false);
		assertEquals(testTree.toString(), "(key=1, priority=84)\n" + 
				"  null\n" + 
				"  (key=6, priority=70)\n" + 
				"    (key=2, priority=31)\n" + 
				"      null\n" + 
				"      (key=4, priority=19)\n" + 
				"        (key=3, priority=12)\n" + 
				"          null\n" + 
				"          null\n" + 
				"        null\n" + 
				"    null");
		assertEquals(testTree.find(0), false);
		assertEquals(testTree.find(2), true);
		assertEquals(testTree.delete(1), true);
		assertEquals(testTree.delete(1), false);
		assertEquals(testTree.toString(), "(key=6, priority=70)\n" + 
				"  (key=2, priority=31)\n" + 
				"    null\n" + 
				"    (key=4, priority=19)\n" + 
				"      (key=3, priority=12)\n" + 
				"        null\n" + 
				"        null\n" + 
				"      null\n" + 
				"  null");
		testTree.delete(2);
		assertEquals(testTree.toString(), "(key=6, priority=70)\n" + 
				"  (key=4, priority=19)\n" + 
				"    (key=3, priority=12)\n" + 
				"      null\n" + 
				"      null\n" + 
				"    null\n" + 
				"  null");
	}

}
