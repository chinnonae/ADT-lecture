package constructandeval;

public abstract class Exp {
	protected String datum;
	protected Exp left, right;
	public abstract int eval();
	public abstract String getDatum();
	public abstract Object accept(Visitor v);
	
	public Exp getLeft(){
		return left;
	}
	
	public Exp getRight(){
		return right;
	}
	
	
}
