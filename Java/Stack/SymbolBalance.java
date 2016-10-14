/* --------------------------------------------------------
 To check whether given expression has balanced symbols
-------------------------------------------------------- */
import java.util.Scanner;
import java.util.Stack;
public class SymbolBalance {

	// returns whether the symbol expression is balanced
	public static boolean IsBalanced(String S) {
		if (S == null || S.length() == 0) {
			return true;
		}
		char ch;
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			ch = S.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stk.push(ch);
				continue;
			}
			if (ch==')') {
				if (stk.pop() == '(') {
					continue;
				}
				else {
					return false;
				}
			}
			if (ch=='}') {
				if (stk.pop() == '{') {
					continue;
				}
				else {
					return false;
				}
			}
			if (ch==']') {
				if (stk.pop() == '[') {
					continue;
				}
				else {
					return false;
				}
			}
		}

		return true;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String expression = scan.next();
		if (IsBalanced(expression)) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not Balanced");	
		}
		
		
	}
}