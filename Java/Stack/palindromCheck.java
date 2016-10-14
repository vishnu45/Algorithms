/* --------------------------------------------------------
 Check whether given string is palindrom or not using stack
-------------------------------------------------------- */
import java.util.Scanner;
import java.util.Stack;
public class palindromCheck {	

	// checks whether given string is palindrom or not
	public static boolean check(String expression) {
		int length = expression.length();
		int to, from;
		Stack<Character> stk = new Stack<Character>();
		// has even number of characters
		if (length%2==0) {
			to = length/2 - 1;
			from = length/2;
		}
		else {
			to = length/2 - 1;
			from = length/2 + 1;
		}
		for (int i = 0; i <= to; i++) {
			stk.push(expression.charAt(i));
		}
		for (int i = from; i < length; i++) {
			if ( !(Character.toString(expression.charAt(i))).equalsIgnoreCase(Character.toString(stk.pop())) ) {
				return false;
			}
		}
		return true;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String expression = scan.next();
		if (check(expression)) {
			System.out.println("Is a palindrom");
		}
		else {
			System.out.println("Not a palindrom");	
		}
	}
}