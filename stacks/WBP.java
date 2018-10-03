package stacks;

import java.util.EmptyStackException;

public class WBP {
	// well-balanced parentheses

	private static final String OPEN = "[{(";
	private static final String CLOSE = "]})";
	private String str;
	private StackSLL<Character> s;

	WBP(String str) {
		this.str = str;
		this.s = new StackSLL<Character>();
	}

	public Boolean is_balanced() {
		boolean balanced = true;
		int index = 0;
		try {
			while (balanced && index < this.str.length()) {
				char currentChar = this.str.charAt(index);
				if (OPEN.indexOf(currentChar) > -1) {
					// if open add to stack
					this.s.push(currentChar);
				} else {
					int closeindex = CLOSE.indexOf(currentChar);
					if (closeindex > -1) {
						// if close check if it closes the right one
						int openindex = OPEN.indexOf(this.s.peek());
						balanced = balanced && openindex == closeindex;
						this.s.pop();
					}
				}
				index++;
			}
		} catch (EmptyStackException e) {
			return false;
		}
		return balanced && this.s.isEmpty();
	}

	public static void main(String[] args) {
		WBP test = new WBP("(()))))");
		System.out.println(test.is_balanced());
		
		//when doing addition / arithmetic ie 2+(3*4) (infix)
		//it is good to use prefix and postfix - specifically postfix
		//ie 2+(3*4) == +2*34 (prefix) 234*+
		//this is so that you have a stack and you add if its a number or multiply if it isn't
		
		//this is very good.
	}

}
