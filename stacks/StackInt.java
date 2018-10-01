package stacks;

public interface StackInt<E> {
	//stack interface (data structure) only has these 4 things.
	void push(E item); //adds to the top of the stack
	E peek(); //looks at the top element of the stack
	E pop(); //removes the top element of the stack
	boolean isEmpty(); //checks if the stack is empty
	int size(); //optional
}
