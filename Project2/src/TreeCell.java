
public class TreeCell {
	private int data;
	private int kind;
	private TreeCell left, right;
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVIDE = 4;
	public static final int OPERATOR = 1;
	public static final int NUMBER = 2;

	public TreeCell(int x, int kind) { data = x; this.kind = kind; }
	public TreeCell(int x, TreeCell right, TreeCell left, int kind) {
		data = x;
		this.left = left;
		this.right = right;
		this.kind = kind;
	}

	public char getData(){
		if(kind == OPERATOR){
			switch(data){
			case PLUS:
				return '+';
			case MINUS:
				return '-';
			case MULTIPLY:
				return '*';
			case DIVIDE:
				return '/';
			}
		}
		return (char) (data+'0');
	}

	public TreeCell getLeft(){
		return this.left;
	}

	public TreeCell getRight(){
		return this.right;
	}

	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public void setData(int data){
		this.data = data;
	}

	public void setLeft(TreeCell cell){
		this.left = cell;
	}

	public void setRight(TreeCell cell){
		this.right = cell;
	}

	public static void printTree(TreeCell root, int level ) {
		if (root != null) {
			printTree(root.right, level+1);
			for (int i=0; i<level; i++) System.out.print("   ");
			System.out.println(root.getData());
			System.out.println();
			printTree(root.left, level+1);
		}
	}
}
