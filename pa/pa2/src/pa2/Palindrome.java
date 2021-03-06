package pa2;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		StackArray<Character> letters = new StackArray<Character>();
		Scanner keyboard = new Scanner(System.in);
		
		// Have user input a string to check whether it's a palindrome
		System.out.print("Enter the string you want to check: ");
		String text = keyboard.nextLine();
		
		// Clean string. Remove non-alphanumeric characters. Normalize case.
		text = text.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
		
		// Create a stack holding the string in reverse order
		for (int i = 0; i < text.length(); i++) {
			letters.push(text.charAt(i));
		}
		
		for (int i = 0; i < text.length(); i++) {
			// Compare each letter to its respective partner in reverse order.
			// If they don't match, then the string isn't a palindrome.
			if (letters.pop() != text.charAt(i)) {
				System.out.println(text + " is not a palindrome.");
				break;
			}
			
			// If we've reached the last letter in the string,
			// it must be a palindrome.
			if (i == text.length() - 1) {
				System.out.println(text + " is a palindrome.");
			}
		}
	}

}
