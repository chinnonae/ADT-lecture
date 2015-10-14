
public class MinusExp extends Exp{
	
	public MinusExp(Exp left, Exp right){
		this.left = left;
		this.right = right;
		this.datum = "-";
	}

	@Override
	public int eval() {
		return left.eval()-right.eval();
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
	
	
}
