
public class TreeCellTest {

	public static void main(String[]args){
		int rootNum = (int)Math.round(Math.random()*20);
		System.out.println("Root: " + rootNum);
		TreeCell<Integer> root = new TreeCell(rootNum);
//		System.out.println(root.insert(1));
//		System.out.println(root.insert(19));
//		System.out.println(root.insert(15));
//		System.out.println(root.insert(9));
//		System.out.println(root.insert(16));
//		System.out.println(root.insert(18));
//		System.out.println(root.insert(13));
//		System.out.println(root.insert(8));
//		System.out.println(root.insert(4));
//		System.out.println(root.insert(6));
//		System.out.println(root.insert(5));
//		System.out.println(root.insert(10));
//		System.out.println(root.insert(14));
		int delete = 19;
		for(int i = 0; i < 20; i++){
			int num = (int)Math.round(10 - Math.random()*20);
			root.insert(num);
			if(i == 5) delete = num;
		}
		print(root);
		System.out.println("\nDelete :" + delete);
		TreeUtil.delete(delete, root);
		print(root);
	}
	
	public static void print(TreeCell root){
		if(root == null) return;
		print(root.getLeft());
		System.out.print(root.getDatum() + " ");
		print(root.getRight());
		
	}
}
