import java.util.*;
public class infix2postfix {

	public static int rank(char operator) {
		switch (operator) {
			case '+' : return 1;
			case '-' : return 1;
			case '*' : return 2;
			case '/' : return 2;
			default : return 0;
		}
	}

	public static void convertToPost(String infix) {
		Stack<Character> expression = new Stack<Character>();
		char ch;
		for (int i = 0; i < infix.length(); i++) {
			ch = infix.charAt(i);
			// System.out.println(">" + ch);
			// System.out.println(expression);
			// check if ch is an operand
			if ( ((int)ch > 64 && (int)ch < 91) || 
				( (int)ch > 96 && (int)ch < 123 ) ) {
				System.out.print(ch);
			}

			// check if ch is a right paranthesis
			else if (ch == ')') {
				if (expression.empty()) {
					continue;
				}
				while (expression.peek() != '(') {
					System.out.print(expression.pop());
				}
				expression.pop();
			}

			// else - ch is a right paranthesis or operator
			else {
				while (!expression.empty()) {
					if (rank(expression.peek()) < rank(ch) ||
						expression.peek() == '(') {
						System.out.print(expression.pop());
					}
					else
						break;
				}				
				expression.push(ch);					
			}

		}
		while (!expression.empty()) {
			System.out.print(expression.pop());
		}
		
	}

	public static void main(String[] args) {
		// read the infix expression
		Scanner scan = new Scanner(System.in);
		String infix = scan.next();
		convertToPost(infix);
	}
}