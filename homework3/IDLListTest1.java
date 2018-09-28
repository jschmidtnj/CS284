package homework3;

public class IDLListTest1 {
	public static void main(String[] args) {
		IDLList<Integer> l1 = new IDLList<Integer>();
		l1.add(3);
		System.out.println(l1);
		l1.add(4);
		System.out.println(l1.size());
		System.out.println(l1);
		System.out.println(l1.remove());
		System.out.println(l1.getHead());
		System.out.println(l1.getLast());
		System.out.println(l1);
		System.out.println(l1.remove());
		System.out.println(l1);
		l1.add(4);
		l1.add(5);
		System.out.println(l1);
		System.out.println(l1.removeLast());
		System.out.println(l1);
		for (int i=0; i<5; i++) {
			l1.add(i);
		}
		System.out.println(l1);
		l1.remove(2);
		System.out.println(l1);
		l1.add(3, 5);
		System.out.println(l1);
		l1.append(10);
		System.out.println(l1);
		System.out.println(l1.get(5));
		l1.removeAt(3);
		System.out.println(l1);
		System.out.println(l1.remove(5));
		System.out.println(l1);
	}
}
