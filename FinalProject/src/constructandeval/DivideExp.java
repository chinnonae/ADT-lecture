package constructandeval;

public class DivideExp extends Exp{

	public DivideExp(Exp left, Exp right){
		super.left = left;
		super.right = right;
		super.datum = "/";
	}
	@Override
	public int eval() {
		return left.eval()/right.eval();
	}

	public Exp getLeft() {
		return left;
	}

	public Exp getRight() {
		return right;
	}

	@Override
	public String getDatum() {
		return datum;
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
