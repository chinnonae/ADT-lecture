import java.util.Stack;


public class ExpTree {

	public static Exp makeExpTree(String postfix){
		Stack<Exp> stack = new Stack<Exp>();

		for(int i = 0; i < postfix.length(); i++){
			char c = postfix.charAt(i);
			if(Character.isDigit(c)){
				stack.push(new Number(c+""));
			}else {				
				Exp e = null;
				Exp first = stack.pop();
				Exp second = stack.pop();
				switch(c){
				case '+':
					e = new PlusExp(second,first);
					break;
				case '-':
					e = new MinusExp(second,first);
					break;
				case '*':
					e = new MultiplyExp(second,first);
					break;
				case '/':
					e = new DivideExp(second,first);
					break;
				}
				stack.push(e);
			}
		}
		return stack.peek();
	}

	public static void printExpTree(Exp root, int level){
		if(root == null) return;
		printExpTree(root.getRight(), level+1);
		for(int i = 0; i < level; i++) System.out.print(" ");
		System.out.println(root.getDatum());
		System.out.println();
		printExpTree(root.getLeft(), level+1);
	}

	public static void main(String[] args) {
		Exp root = makeExpTree(Util.IntoPos("7*5+(8+9*2)"));
		printExpTree(root, 0);
		System.out.println(root.eval());
	}
}
