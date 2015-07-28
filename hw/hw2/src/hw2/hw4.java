package hw2;

public class hw4 {

	public static void main(String[] args) {
		System.out.println(contains('a', "apple"));
		System.out.println(contains('b', "people"));
		System.out.println(contains('n', "recursion"));
	}

	public static Boolean contains(char letter, String str) {
		if (str.length() == 1) {
			return letter == str.charAt(0);
		}
		
		return letter == str.charAt(0) || contains(letter, str.substring(1));
	}
}
