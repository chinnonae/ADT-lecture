
class TreeCell<T> {
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
   
}
