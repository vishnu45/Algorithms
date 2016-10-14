/* --------------------------------------------------------
 Reverse a string using stack
-------------------------------------------------------- */
import java.util.Scanner;
import java.util.Stack;
public class reverseString {	

	// reverses a string
	public static String reverStr(String phrase) {
		Stack<Character> stk = new Stack<Character>();
		String reverse = "";
		// push each character onto Stack
		for (int i = 0; i < phrase.length(); i++) {
			stk.push(phrase.charAt(i));
		}
		// pop out each character on the stack
		while (!stk.empty()) {			
			reverse += stk.pop();
		}
		return reverse;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String phrase = scan.next();
		System.out.println(reverStr(phrase));
	}
}