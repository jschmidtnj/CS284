package stacks;

public class TestPalindrome {
	public static void main(String[] args) {
		PalindromeChecker c1 = new PalindromeChecker("kayak");
		System.out.println(c1.isPalindrome());
		PalindromeChecker c2 = new PalindromeChecker("asdf");
		System.out.println(c2.isPalindrome());
		PalindromeChecker c3 = new PalindromeChecker("I saw I was I");
		System.out.println(c3.isPalindrome());
	}
}
