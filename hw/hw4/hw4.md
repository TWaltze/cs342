Tyler Waltze

7/27/15

MET CS 342

Homework 4

1. Formulate a recursive definition whether it is true that a string contains a specified character.

    **Problem**: String = Char + String

    **Base case**: String of length 1

    **N**: Char == String.charAt(0), Contains(String.substring(1))

2. Formulate a recursive definition of x raised to the power of y for non-negative y. Hints: for the base case, specify what the result is when y is 0, for the recursive case define the result as x multiplied by the result for a smaller y.

    **Problem**: X * X^(Y - 1)

    **Base case**: X^0 = 1

    **N**: X * X^(N - 1)

3. Formulate a recursive definition for the sum of squares of the numbers in an array.

    **Problem**: [2, 4, 6] = 2^2 + 4^2 + 6^3

    **Base case**: arr.length() == 1 => arr[0] * 2

    **N**: arr[0] ^ 2 + squares(arr[{1, 2, .., arr.length}])

Format your definitions to show what the result IS rather than what you do first and what next, clearly identify the base and recursive cases.

4. Implement one of the recursive definitions above (your choice) as a recursive Java method. Communicate through parameters and return values (do not use data fields). Please submit code and show result.

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

    **Output**:

    true

    false

    true
