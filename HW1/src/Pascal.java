import java.util.ArrayList;


public class Pascal {
				
	public static void pascal(int n){
		solvePascal(n, n);
	}
	
	public static int solvePascal(int line, int row){
		

		int comb = combination(line, row);
		if(line == 0){
			System.out.print(comb);
			return comb;
		}else if(row > 0){
			solvePascal(line, row - 1);
			System.out.print(comb+" ");
		} else {
			solvePascal(line - 1, line - 1);
			System.out.print("\n"+comb+" ");
		}
		return comb;
	
		
		
	}
	
	public static int combination(int n, int r){
		if(r == 0 || r == n)
			return 1;
		return combination(n-1, r) + combination(n-1,r-1);
	}
	
	public static void main(String[]args){
		long start = System.nanoTime();
		pascal(20);
		System.out.println("\n" + (System.nanoTime() - start) + " ns.");
	}
}
