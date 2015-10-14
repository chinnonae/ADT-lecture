
public abstract class Exp {
	protected String datum;
	protected Exp left, right;
	public abstract int eval();
	public abstract String getDatum();
	
	public Exp getLeft(){
		return left;
	}
	
	public Exp getRight(){
		return right;
	}
}
