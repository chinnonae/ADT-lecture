package constructandeval;

public class MultiplyExp extends Exp {
	
	public MultiplyExp (Exp left, Exp right){
		super.left = left;
		super.right = right;
		super.datum = "*";
	}
	
	@Override
	public int eval() {
		return left.eval()*right.eval();
	}

	public Exp getLeft() {
		return left;
	}

	public Exp getRight() {
		// TODO Auto-generated method stub
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
