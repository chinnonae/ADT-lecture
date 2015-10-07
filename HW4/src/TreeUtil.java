
public class TreeUtil {

	public static TreeCell search(Object x, TreeCell root){
		if(root == null) return null;
		if(root.getDatum().equals(x))return root;
		TreeCell goLeft = search(x, root.getLeft());
		TreeCell goRight = search(x, root.getRight());
		if(goLeft != null) return goLeft;
		if(goRight != null) return goRight;
		return null;
	}

	public static TreeCell delete(Object x, TreeCell root){
		TreeCell toBeReplaced = search(x, root);
		return delete(toBeReplaced, root);
	}
	
	public static TreeCell delete(TreeCell toBeReplaced, TreeCell root){
		TreeCell newRoot = getNewRoot(toBeReplaced);
		TreeCell parent = getParent(newRoot.getDatum(), root);
		toBeReplaced.setDatum(newRoot.getDatum());
		if(parent.getLeft() == newRoot) 
			parent.setLeft(newRoot.getRight());
		else if(parent.getRight() == newRoot) 
			parent.setRight(newRoot.getLeft());

		return root;

	}

	public static TreeCell getParent(Object x, TreeCell root){
		TreeCell parent = null;
		if(root.getRight() != null){
			if(root.getRight().getDatum().equals(x))return root;
			parent = getParent(x, root.getRight());
		}
		if(root.getLeft() != null && parent == null){
			if(root.getLeft().getDatum().equals(x))return root;
			parent = getParent(x, root.getLeft());
		}
		return parent;
	}

	static TreeCell getNewRoot(TreeCell root){
		TreeCell curr = root, scout = null;
		boolean left = false, right = false;
		if(root.getRight() != null){
			scout = root.getRight();
			right = true;
		}else if(root.getLeft() != null){
			scout = root.getLeft();
			left = true;
		}else{
			return root;
		}
		while(scout != null){
			if(left) {
				if(scout.getRight() == null) break;
				curr = scout;
				scout = curr.getRight();
			}else if (right){
				if(scout.getLeft() == null) break;
				curr = scout;
				scout = curr.getLeft();
			}
		}
		return scout;

	}
}
