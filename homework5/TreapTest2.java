package homework5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is a class for testing the Treap class.
 * I pledge my honor that I have abided by the Stevens Honor System. - Sean Trinh
 * @author seantrinh
 *
 */
public class TreapTest2 {
	@Test
	public void test() {
		Treap<Character> testTree = new Treap<Character>();
		//Testing the add and toString methods
		assertEquals(true, testTree.add('g',80));
		assertEquals("(key=g, priority=80)\n" + "  null\n" + "  null\n", testTree.toString());
		assertEquals(true, testTree.add('p',99));
		assertEquals("(key=p, priority=99)\n" + "  (key=g, priority=80)\n" + "    null\n" + "    null\n" + "  null\n", testTree.toString());
		assertEquals(true, testTree.add('a',60));
		assertEquals(true, testTree.add('z',47));
		assertEquals(true, testTree.add('v',21));
		assertEquals(true, testTree.add('r',40));
		assertEquals(true, testTree.add('w',32));
		assertEquals(true, testTree.add('u',75));
		assertEquals(true, testTree.add('x',25));
		assertEquals(true, testTree.add('j',65));
		assertEquals("(key=p, priority=99)\n"
				+ "  (key=g, priority=80)\n"
				+ "    (key=a, priority=60)\n"
				+ "      null\n"
				+ "      null\n"
				+ "    (key=j, priority=65)\n"
				+ "      null\n"
				+ "      null\n"
				+ "  (key=u, priority=75)\n"
				+ "    (key=r, priority=40)\n"
				+ "      null\n"
				+ "      null\n"
				+ "    (key=z, priority=47)\n"
				+ "      (key=w, priority=32)\n"
				+ "        (key=v, priority=21)\n"
				+ "          null\n"
				+ "          null\n"
				+ "        (key=x, priority=25)\n"
				+ "          null\n"
				+ "          null\n"
				+ "      null\n", testTree.toString());
		
		//Testing the delete method
		assertEquals(true, testTree.delete('z'));
		assertEquals("(key=p, priority=99)\n"
				+ "  (key=g, priority=80)\n"
				+ "    (key=a, priority=60)\n"
				+ "      null\n"
				+ "      null\n"
				+ "    (key=j, priority=65)\n"
				+ "      null\n"
				+ "      null\n"
				+ "  (key=u, priority=75)\n"
				+ "    (key=r, priority=40)\n"
				+ "      null\n"
				+ "      null\n"
				+ "    (key=w, priority=32)\n"
				+ "      (key=v, priority=21)\n"
				+ "        null\n"
				+ "        null\n"
				+ "      (key=x, priority=25)\n"
				+ "        null\n"
				+ "        null\n", testTree.toString());
		assertEquals(true, testTree.delete('u'));
		assertEquals(true, testTree.delete('a'));
		assertEquals(true, testTree.delete('j'));
		assertEquals(true, testTree.delete('w'));
		assertEquals(true, testTree.delete('r'));
		assertEquals(true, testTree.delete('v'));
		assertEquals(true, testTree.delete('x'));
		assertEquals("(key=p, priority=99)\n"
				+ "  (key=g, priority=80)\n"
				+ "    null\n"
				+ "    null\n"
				+ "  null\n", testTree.toString());
		assertEquals(true, testTree.delete('p'));
		assertEquals("(key=g, priority=80)\n"
				+ "  null\n"
				+ "  null\n", testTree.toString());
		assertEquals(true, testTree.delete('g'));
		assertEquals("null\n", testTree.toString());
		
		//Testing the find methods
		Treap<Integer> testTree2 = new Treap<Integer>();
		assertEquals(true, testTree2.add(4,19));
		assertEquals(true, testTree2.add(2,31));
		assertEquals(true, testTree2.add(6,70));
		assertEquals(true, testTree2.add(1,84));
		assertEquals(true, testTree2.add(3,12));
		assertEquals(true, testTree2.add(5,83));
		assertEquals(true, testTree2.add(7,26));
		assertEquals("(key=1, priority=84)\n"
				+ "  null\n"
				+ "  (key=5, priority=83)\n"
				+ "    (key=2, priority=31)\n"
				+ "      null\n"
				+ "      (key=4, priority=19)\n"
				+ "        (key=3, priority=12)\n"
				+ "          null\n"
				+ "          null\n"
				+ "        null\n"
				+ "    (key=6, priority=70)\n"
				+ "      null\n"
				+ "      (key=7, priority=26)\n"
				+ "        null\n"
				+ "        null\n", testTree2.toString());
		assertEquals(false, testTree2.find(10));
		//assertEquals(null, testTree2.find(null));
		
	}
}
