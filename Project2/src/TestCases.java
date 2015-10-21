
public class TestCases {
	
	public static void test1(){
		String post = Util.IntoPos("(8*9+2)*9*2+9");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
		printExpTree(post);
	}
	
	public static void test2(){
		String post = Util.IntoPos("(9+6/3*5)-(5)");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
		printExpTree(post);
	}
	
	public static void test3(){
		String post = Util.IntoPos("(9*(8+2))*((9+5)*5)+(((5*(1+5)*2+9*9)))");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
		printExpTree(post);
	}
	
	public static void test4(){
		String post = Util.IntoPos("(1*1+1-2+2-1)*1*(1*4)*(1/1)+((1+5)/3*2-3)/(1*1*1*1)");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
		printExpTree(post);
	}
	
	public static void test5(){
		String post = Util.IntoPos("(9+9)*(9/9-1)*(4/2*5+2)");
		System.out.println("Postfix: " + post);
		TreeCell root = Util.makeExpTree(post);
		printTreeInfo(root);
		printExpTree(post);
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
	
	public static void printExpTree(String postfix){
		System.out.println("\n\n ExpTree:");
		ExpTree.printExpTree(ExpTree.makeExpTree(postfix), 0);
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
		
		System.out.println("------- Test 4 -------");
		test4();
		System.out.println("----End of Test 4 ----\n\n\n");
		
		System.out.println("------- Test 5 -------");
		test5();
		System.out.println("----End of Test 5 ----\n\n\n");
	}
}
