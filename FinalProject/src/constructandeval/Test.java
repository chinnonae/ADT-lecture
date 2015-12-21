package constructandeval;

public class Test {
	
	public static void main(String[]args){
		Exp root = ExpTree.makeExpTree(Util.IntoPos("(5+9/2*2-1)"));
		Visitor v = new Evaluator();
		System.out.println(root.accept(v));
	}
}
