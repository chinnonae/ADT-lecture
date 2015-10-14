
public class Number extends Exp {
	
	public Number(String num){
		datum = num;
	}
	@Override
	public int eval() {
		return Integer.parseInt(datum);
	}

	@Override
	public String getDatum() {
		return datum;
	}
	
	
}
