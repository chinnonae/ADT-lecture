
public class TestCases {
	
	public static void test1(){
		String post = Util.IntoPos("(8*9+2)-9*2+9");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
	}
	
	public static void test2(){
		String post = Util.IntoPos("(9+6/3*5)-5");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
	}
	
	public static void test3(){
		String post = Util.IntoPos("(9*(8+2))*((9+5)*5)+(((5*(1+5)*2+9*9)))");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
	}
	
	public static void printTreeInfo(TreeCell root){
		System.out.println("Tree: ");
		root.printTree(root, 0);
		System.out.print("Prefix from Tree: "); 
		Util.printPrefix(root);
		System.out.print("\nPostfix from Tree: ");
		Util.printPostfix(root);
		System.out.print("\nInfix from Tree: ");
		Util.printInfix(root);
		System.out.print("\nEvaluate the equation from Tree: ");
		System.out.println(Util.eval(root));
	}
	
	
	
	public static void main(String[]args){
		System.out.println("------- Test 1 -------");
		test1();
		System.out.println("----End of Test 1 ----\n\n\n");
		
		System.out.println("------- Test 2 -------");
		test2();
		System.out.println("----End of Test 2 ----\n\n\n");
		
		System.out.println("------- Test 3 -------");
		test3();
		System.out.println("----End of Test 3 ----\n\n\n");
	}
}
