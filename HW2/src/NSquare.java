
public class NSquare {

	public static int square(int n){
		if(n == 1) return 1;
		return square(n-1) + (2*(n-1)) + 1;
	}
	
	public static void main(String[]args){
		System.out.println(square(5));
	}
}
