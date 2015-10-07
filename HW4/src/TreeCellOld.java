
class TreeCellOld<T> {
   private T datum;
   private TreeCellOld<T> left, right;

   public TreeCellOld(T x) { datum = x; }
   public TreeCellOld(T x, TreeCellOld<T> lft, TreeCellOld<T> rgt) {
      datum = x;
      left = lft;
      right = rgt;
   }
   
   public T getDatum(){
	   return this.datum;
   }
   
   public TreeCellOld getLeft(){
	   return this.left;
   }
   
   public TreeCellOld getRight(){
	   return this.right;
   }
   
   public void setDatum(T datum){
	   this.datum = datum;
   }
   
   public void setLeft(TreeCellOld<T> cell){
	   this.left = cell;
   }
   
   public void setRight(TreeCellOld<T> cell){
	   this.right = cell;
   }
   
   public TreeCellOld delete(Object x, TreeCellOld T){
	   TreeCellOld toBeDeleted = search(x, T);
	   TreeCellOld newRoot = getNewRoot(toBeDeleted);

	   if(newRoot != null){
		   toBeDeleted.setDatum(newRoot.getDatum());
	   }
	   else{
		   TreeCellOld xParent = getParent(x, T);
		   if(xParent.left.getDatum().equals(x)) xParent.left = null;
		   else if(xParent.right.getDatum().equals(x)) xParent.right = null;
	   }
	   return T;
   }
   
   public TreeCellOld search(Object x, TreeCellOld root){
	   if(root == null) return null;
	   if(root.getDatum().equals(x)){return root; }
	   TreeCellOld leftSearch = search(x, root.left);
	   TreeCellOld rightSearch = search(x, root.right);
	   if(leftSearch != null){ return leftSearch; }
	   if(rightSearch != null){ return rightSearch; }
	   return null;
   }
      
   public TreeCellOld getParent(Object x, TreeCellOld root){
	   if(search(x,root.left)!=null || search(x,root.right) != null)
		   return root;
	   return null;
   }
   
   private TreeCellOld getNewRoot(TreeCellOld root){
	   TreeCellOld curr = root, scout = null;
	   boolean left = false, right = false;
	   if(root.right != null){
		   scout = root.right;
		   right = true;
		   System.out.println("get min from right");
	   }else if(root.left != null){
		   scout = root.left;
		   left = true;
		   System.out.println("get max from left");
	   }else{
		   return null;
	   }
	   T datum = null;
	   while(scout != null){
		   if(left) {
			   if(scout.right == null){
				   if(curr == root) curr.left = null;
				   else curr.right = null;
				   break;
			   }
			   curr = scout;
			   scout = curr.right;
		   }else if (right){
			   if(scout.left == null) {
				   if(curr == root) curr.right = null;
				   else curr.left = null;
				   break;
			   }
			   curr = scout;
			   scout = curr.left;
		   }
		   
		   
	   }
	   return scout;
	  
   }
   
   public boolean insert(int num){
	   if(search(num, this) != null) return false;
	   binaryInsert(num, this);
	   return true;
	   
   }
   
   private void binaryInsert(int num, TreeCellOld cell){
	   if(cell.left == null && num < (int)cell.getDatum()) cell.left = new TreeCellOld(num);
	   else if(cell.right == null && num > (int)cell.getDatum()) cell.right = new TreeCellOld(num);
	   
	   if(num < (int)cell.getDatum()){
		   if(cell.left == null) cell.left = new TreeCellOld(num);
		   else binaryInsert(num, cell.left);
	   }else if(num > (int) cell.getDatum()){
		   if(cell.right == null) cell.right = new TreeCellOld(num);
		   else binaryInsert(num, cell.right);
	   }
		
   }
   
   
   
}
