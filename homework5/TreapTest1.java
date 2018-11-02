package homework5;

public class TreapTest1 {

	public static void main(String[] args) {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		System.out.println(testTree);
		testTree.add(2, 31);
		System.out.println(testTree);
		testTree.add(6, 70);
		System.out.println(testTree);
		testTree.add(1, 84);
		System.out.println(testTree);
		System.out.println(testTree.add(3, 12));
		System.out.println(testTree);
		System.out.println(testTree.delete(1));
		System.out.println(testTree);
		System.out.println(testTree.delete(2));
		System.out.println(testTree);
		testTree.add(7, 26);
		System.out.println(testTree);
		System.out.println(testTree.add(5, 7));
		System.out.println(testTree);
		System.out.println(testTree.add(9, 7));
		System.out.println(testTree);
		System.out.println(testTree.find(0));
		System.out.println("test");
		System.out.println(testTree.delete(1));
		System.out.println(testTree);
		testTree.add(10);
		System.out.println(testTree);
	}
}
