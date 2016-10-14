/* --------------------------------------------------------
 Postfix expression evaluation using stacks
-------------------------------------------------------- */
import java.util.Scanner;
import java.util.Stack;
public class postfixEval {

	// perform arithmetic operation
	public static int operate(int a, int b, char operator) {
		switch (operator) {
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;
			default: return 0;
		}
	}

	// evaluates the postfix expression and returns the value
	public static int evaluate(String expression) {
		Stack<Integer> stk = new Stack<Integer>();
		char ch;
		int a, b, val;
		for (int i = 0; i < expression.length(); i++) {
			ch = expression.charAt(i);
			
			// check if operand (numbers)
			if ( (int)ch >= 48 && (int)ch <= 57 ) {
				// push the value onto stack (ASCII conversion)
				stk.push((int)ch - 48);
			}

			// else -> if operator
			else {
				// retrieve the previous 2 operands from stack
				b = stk.pop();
				a = stk.pop();
				// perform the specified operation on these
				val = operate(a, b, ch);
				// push value back to stack
				stk.push(val);
			}
		}
		// pop back the final value on stack
		return stk.pop();
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String expression = scan.next();
		System.out.println(evaluate(expression));
	}
}