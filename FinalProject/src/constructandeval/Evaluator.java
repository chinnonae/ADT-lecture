package constructandeval;

public class Evaluator implements Visitor{

	@Override
	public Object visit(PlusExp n) {
		return (Integer)(n.left.accept(this)) + (Integer)(n.right.accept(this));
	}

	@Override
	public Object visit(MultiplyExp n) {
		return (Integer)(n.left.accept(this)) * (Integer)(n.right.accept(this));
	}

	@Override
	public Object visit(MinusExp n) {
		return (Integer)(n.left.accept(this)) - (Integer)(n.right.accept(this));
	}

	@Override
	public Object visit(DivideExp n) {
		return (Integer)(n.left.accept(this)) / (Integer)(n.right.accept(this));
	}

	@Override
	public Object visit(Number n) {
		return (Integer)(n.eval());
	}


	

}
