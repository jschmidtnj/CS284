package stacks;

public class PalindromeChecker {
	private String inputString;
	private StackSLL<Character> charStack;

	public PalindromeChecker(String str) {
		inputString = str.replaceAll(" ", "");
		charStack = new StackSLL<Character>();
		for (int i = 0; i < inputString.length(); i++) {
			charStack.push(inputString.charAt(i));
		}
	}

	private String buildReverse() {
		StringBuilder s = new StringBuilder();
		while (!charStack.isEmpty()) {
			s.append(charStack.pop());
		}
		return s.toString();
	}

	public boolean isPalindrome() {
		return inputString.equalsIgnoreCase(buildReverse());
	}
}
