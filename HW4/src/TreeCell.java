
public class TreeCell<T> {
	private T datum;
	private TreeCell<T> left, right;

	public TreeCell(T x) { datum = x; }
	public TreeCell(T x, TreeCell<T> lft, TreeCell<T> rgt) {
		datum = x;
		left = lft;
		right = rgt;
	}

	public T getDatum(){
		return this.datum;
	}

	public TreeCell getLeft(){
		return this.left;
	}

	public TreeCell getRight(){
		return this.right;
	}

	public void setDatum(T datum){
		this.datum = datum;
	}

	public void setLeft(TreeCell<T> cell){
		this.left = cell;
	}

	public void setRight(TreeCell<T> cell){
		this.right = cell;
	}
	

	public boolean insert(int num){
		binaryInsert(num, this);
		return true;

	}

	private boolean binaryInsert(int num, TreeCell cell){
		if(cell.left == null && num < (int)cell.getDatum()) cell.left = new TreeCell(num);
		else if(cell.right == null && num > (int)cell.getDatum()) cell.right = new TreeCell(num);

		if(num < (int)cell.getDatum()){
			if(cell.left == null) {
				cell.left = new TreeCell(num);
				return true;
			}
			else return binaryInsert(num, cell.left);
		}else if(num > (int) cell.getDatum()){
			if(cell.right == null){
				cell.right = new TreeCell(num);
				return true;
			}
			else return binaryInsert(num, cell.right);
		}
		return false;
	}
}
