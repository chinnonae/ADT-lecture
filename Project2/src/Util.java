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
			case '(': 
				stack.push(c);
				break;
			case '+': case '-':
				stack.push(c);
				if(index+2 < infix.length() && infix.charAt(index+1) != '(' && infix.charAt(index+2) != '*')
					pop = true;
				break;
			case '*':
				stack.push(c);
				if(infix.charAt(index+1)!='(') pop = true;
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek()!='('){
					post.append(stack.pop());
				}
				if(!stack.isEmpty()) stack.pop();
				break;
			default:
				post.append(c);
				if(pop && !stack.isEmpty()){
					post.append(stack.pop());
					while(index+1 < infix.length() && !stack.isEmpty() && stack.peek() != '(' && stack.peek() == '+' && infix.charAt(index+1) != '*'){
						post.append(stack.pop());
					}
					pop = false;
				}
			}
			index++;
		}
		while(!stack.isEmpty()){
			char element = stack.pop();
			if(element != '(') post.append(element);
		}
		return post.toString();
	}

	public static TreeCell makeExpTree(String postfix){
		Stack<TreeCell> stack = new Stack<TreeCell>();
		for(int i = 0; i < postfix.length(); i++){
			char c = postfix.charAt(i);
			if(Character.isDigit(c)){
				stack.push(new TreeCell(c-'0', TreeCell.NUMBER));
			}else {
				TreeCell cell = new TreeCell(0, stack.pop(), stack.pop(), TreeCell.OPERATOR);
				stack.push(cell);
				switch(c){
				case '+':
					cell.setData(TreeCell.PLUS);
					break;
				case '-':
					cell.setData(TreeCell.MINUS);
					break;
				case '*':
					cell.setData(TreeCell.MULTIPLY);
					break;
				case '/':
					cell.setData(TreeCell.DIVIDE);
					break;
				}
			}
		}
		return stack.peek();
	}

	public static void printPrefix(TreeCell root){
		if(root==null)return;
		System.out.print(root.getData());
		printPrefix(root.getLeft());
		printPrefix(root.getRight());
	}

	public static void printPostfix(TreeCell root){
		if(root==null)return;
		printPostfix(root.getLeft());
		printPostfix(root.getRight());
		System.out.print(root.getData());
	}

	public static void printInfix(TreeCell root){
		if(root==null)return;
		if(root.getLeft()!=null) System.out.print('(');
		printInfix(root.getLeft());
		System.out.print(root.getData());
		printInfix(root.getRight());
		if(root.getRight()!=null) System.out.print(')');
	}

	public static int eval (TreeCell root){
		char c = root.getData();
		if(Character.isDigit(c)){
			return c-'0';
		}
		int right = eval(root.getRight());
		int left = eval(root.getLeft());
		switch(root.getData()){
		case '+':
			return right+left;
		case '-':
			return left-right;
		case '*':
			return right*left;
		case '/':
			return left/right;
		}
		return 0;
	}

	public static void main(String[]args){
		System.out.println(IntoPos("(8+9*(4+5*7+6))+3*5+4"));
		System.out.println(IntoPos("1+8+9*2"));
		System.out.println(IntoPos("7*5+(8+9*2)"));
		System.out.println(IntoPos("7*5+((8+9)*2)"));
		System.out.println(IntoPos("((5+6*2*(4+8)))*(2+2)"));

		TreeCell root = makeExpTree(IntoPos("((5+6*2*(4+8)))*(2+2)"));
		TreeCell.printTree(root, 0);

		printPrefix(root);
		System.out.println();
		printPostfix(root);
		System.out.println();
		printInfix(root);
		System.out.println();
		System.out.println(eval(root));
	}



}
