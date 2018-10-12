# CS284 Test 1

## Time Complexity

determine time complexity on a snippet of code  
used [this](http://www.sciweavers.org/free-online-latex-equation-editor) to get the math equation below.  
used [this](https://www.markdowntopdf.com/) to convert to a pdf.  

### Time Complexity and O(n)

```java
public void complexity2(int n) {
		/*
		 * Table -> T(n) -> O(n)
		 * i        0 1 2 3 ... n-1
		 * # iter   0 1 2 3 ... n-1
		 * T(n) = sum i=1 to n-1 of i*2 => T(n) = n^2-n
		 * O(n) = n^2
		 */
		for (int i=0; i<n; i++) {
			for (int j=i; j>0; j--) {
				//this counts as 2 units of time
				System.out.println("hello");
				System.out.println("bye");
			}
		}
	}
```

![equation](http://www.sciweavers.org/tex2img.php?eq=%5Csum_%7Bi%3D1%7D%5E%7Bn-1%7D%20n%3D%20%5Cfrac%7Bn%2A%28n-1%29%7D%7B2%7D&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)  

```java
public class Complexity {
	public static void method0(int n) {
		// O(n) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	public static void method3(int n) {
		// O(n*log(n)) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j *= 2) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	public static void method4(int n) {
		// O(n^3) complexity
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.println("Operation " + counter);
					counter++;
				}
			}
		}
	}

	public static void method5(int n) {
		// O(log(log(n)))
		int counter = 0;
		for (int i = n; i > 1; i = (int) Math.sqrt(i)) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	public static int method6(int n) {
		// O(2^n) complexity
		if (n <= 0) {
			return 0;
		} else {
			return 1 + method6(n - 1) + method6(n - 1);
		}
	}
}
```

```java
public class Examples {
	public void method1(int n) {
		//O(n)
		for (int i=0; i<n; i++) {
			System.out.println("test");
		}
	}
	public void method2(int n) {
		//O(n^2)
		for (int i=0; i < n; i++) {
			for (int j=0; j<n; j++) {
				System.out.println("test");
			}
		}
	}
	public void method3(int n) {
		//O(1)
		for (int i=0; i < n; i++) {
			System.out.println("test");
			break;
		}
	}
	public void method4(int n) {
		//O(n^2) still
		//n(n-5)
		//n^2-5n
		for (int i=0; i < n; i++) {
			for (int j=5; j<n; j++) {
				System.out.println("test");
			}
		}
	}
	public void method5(int n) {
		//O(n^2)
		//n*(n/2) = n^2/2
		for (int i=0; i < n; i++) {
			for (int j=0; j<n; j+=2) {
				System.out.println("test");
			}
		}
	}
	public void method6(int n) {
		//O(n*log(n))
		//log base 2
		//n*log(n)
		for (int i=0; i < n; i++) {
			//starts at 1 - this gives it away (also increment is *)
			for (int j=1; j<n; j*=2) {
				System.out.println("test");
			}
		}
	}
	public void method7(int n) {
		//O(n)
		//time is 3n
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
	}
	public void method8(int n) {
		//O(n^2)
		//time is n + n^2
		for (int i=0; i < n; i++) {
			System.out.println("test");
		}
		for (int i=0; i < n; i++) {
			for (int k=n; k > 0; k--) {
				System.out.println("test");
			}
		}
	}
	public void method9(int n) {
		//O(log(log(n)))
		for (int i=0; i < n; i*=i) {
			System.out.println("test");
		}
		/*
		 * another method for O(log(log(n)))
		 * for (int i=0; i < n; i++) {
		 * 	for (int j=0; i < n; j*=i) {
		 * 		System.out.println("test");
		 * 	}
		 * }
		 */
	}
}
```

## Linked list

programming exercise (1 or 2) - maybe double linked.

### Single Linked List

```java

package linkedlist;

import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.IllegalArgumentException;

public class LinkedList<E> {
	private Node<E> head;
	
	private class Node<E>{
		private Node<E> next;
		private E data;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public LinkedList() {
		this.head = null;
	}

	public String concatenate() {
		return concatenate(this.head);
	}

	public void add(E item) {
		head = new Node<E>(item, head);
		size++;
	}

	public E get(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("get: index not found");
		}
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public Boolean member(E item) {
		Node<E> current = head;
		// comparison from left to right - short circuit vs long circuit
		// just & or | result in long circuit, && and || result in short circuit
		while (current != null && current.data != item) { // if these two are switched, you get a null pointer exception
															// (example of short circuit)
			current = current.next;
		}
		return current != null; // do it this way instead of if else statements (duh)
	}

	public void add(E item, int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("add: cannot add at this index");
		}
		// operation reused at beginning
		if (index == 0) {
			this.add(item);
		} else {
			Node<E> previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
			}
			Node<E> next = previous.next;
			Node<E> newNode = new Node<E>(item, next);
			previous.next = newNode;
			size++;
		}
	}
	
	public String concatenate(Node<E> head) {
		try {
			StringBuilder result = new StringBuilder();
			for (Node<E> current = head; current != null; current = current.next) {
				result.append(current.data);
			}
			return result.toString();
		} catch(Exception e) {
			throw new IllegalArgumentException("bad argument must be a String");
		}
	}
	
	public <E extends Number> Integer summation(Node<E> head) {
		try {
			int result = 0;
			for (Node<E> current = head; current != null; current = current.next) {
				result = result + current.data.intValue();
			}
			return result;
		} catch(Exception e) {
			throw new IllegalArgumentException("bad argument must be an int");
		}
	}
	
	public Node<E> reverse(Node<E> head) {
		Node current = head;
		Node previous = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}
```

## Stacks and Queues

stacks are very similar to queues - an exercise on one of the two  
  
stacks are like a pancake - you can only access the top element and you add on the top.  
queues are like a line at a coffee shop - you can only access the top element and you add to the back of the line.  

### Stacks

```java
package stacks;

public interface StackInt<E> {
	//stack interface (data structure) only has these 4 things.
	void push(E item); //adds to the top of the stack
	E peek(); //looks at the top element of the stack
	E pop(); //removes the top element of the stack
	boolean isEmpty(); //checks if the stack is empty
	int size(); //optional
}
```

```java
package stacks;

import java.util.EmptyStackException;

public class StackSLL<E> implements StackInt<E> {

	public class Node<F> {
		// Data Fields for Node
		private F data;
		private Node<F> next;

		public Node(F data) {
			super();
			this.data = data;
		}

		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	// Data fields
	private Node<E> top;
	private int size;

	// Constructor
	StackSLL() {
		top = null;
		size = 0;
	}

	public void push(E item) {
		top = new Node<E>(item, top);
		size++;
	}

	public E peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public E pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		E temp = top.data;
		top = top.next;
		size--;
		return temp;
	}

}
```

### Queues

```java
package stacks;
import java.util.NoSuchElementException;
public class QueueSLL<E> {
	public class Node<F> {
		// Data Fields for Node
		private F data;
		private Node<F> next;

		public Node(F data) {
			super();
			this.data = data;
		}
		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}

	}
	private Node<E> front;
	private Node<E> rear;
	private int size;
	QueueSLL() {
		front = null;
		rear = null;
		size = 0;
	}
	public boolean offer(E item) {
		rear = new Node<E>(item, rear);
		if (front == null) { //queue is empty
			front = rear;
		}
		size++;
		return true;
		//return false if there is a size limit and the limit has been reached
	}
	public E element() {
		//returns item at the head of the queue
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return front.data;
	}
	//public String toString() {}
	public static void main(String[] args) {
		QueueSLL<Integer> q1 = new QueueSLL<Integer>();
		for (int i=0; i<5; i++) {
			q1.offer(i);
		}
		System.out.println(q1);
		q1.remove();
		System.out.println(q1);
		q1.remove();
		q1.remove();
		System.out.println(q1);
		q1.remove();
		q1.remove();
		System.out.println(q1);
	}
}
```