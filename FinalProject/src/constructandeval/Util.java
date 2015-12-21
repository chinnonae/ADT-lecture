package constructandeval;
import java.util.Stack;


public class Util {

	public static String IntoPos(String infix){
		Stack<Character> stack  = new Stack<Character>();
		StringBuilder post = new StringBuilder();
		int index = 0;
		boolean pop = false;
		while(index < infix.length()){
			char c = infix.charAt(index);
			switch(c){
			case '+': case '-':
				stack.push(c);
				if(index+2 < infix.length() && infix.charAt(index+1) != '(' && infix.charAt(index+2) != '*' && infix.charAt(index+2) != '/' ){
					pop = true;
				}
				break;
			case '*': case '/':
				stack.push(c);
				if(infix.charAt(index+1) != '(' ) 
					pop = true;
				break;
			case '(':
				stack.push(c);
				break;
			case ')':
				while(!stack.empty() && stack.peek() != '(') 
					post.append(stack.pop());
				if(!stack.empty() && stack.peek() == '(')stack.pop();
				if(!stack.empty() && stack.peek() != '(')post.append(stack.pop());
				break;
			default:
				
				post.append(c);
				if(pop && !stack.isEmpty()){
					char cc = stack.pop();
					if(cc != '(') post.append(cc);
					while(index+1 < infix.length() && !stack.isEmpty() && stack.peek() != '(' && (stack.peek() == '+' || stack.peek() == '-') && (infix.charAt(index+1) != '*' && infix.charAt(index+1) != '/')){
						post.append(stack.pop());
					}
					pop = false;
				}
			}
			index++;
		}
		while(!stack.empty() && stack.peek() != '(') post.append(stack.pop());
		return post.toString();

	}

	
}
