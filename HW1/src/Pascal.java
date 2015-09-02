import java.util.ArrayList;


public class Pascal {
	
	static ArrayList<int[]> pascalTri;
	
	public static void pascal(int n){
		
		if(n == 1 ){
			pascalTri = new ArrayList<int[]>();
			pascalTri.add(new int[] {1});
			System.out.println("1");
			return;
		} else if (n == 2){
			pascal(n-1);
			pascalTri.add(new int[] {1,1});
			System.out.println("1 1");
			return;
		}
		
		pascal(n-1);
		
		int[] currLine = new int[n];
		int[] prevLine = pascalTri.get(n-2);
		
		currLine[0] = 1;
		currLine[n-1] = 1;
		
		pascalTri.add(currLine);
		
		for(int i = 0; i < n; i++){
			if(!(i==0 || i==n-1))
				currLine[i] = prevLine[i] + prevLine[i-1];
			System.out.print(currLine[i] + " ");
		}
		System.out.println();
		
	}
	
	public static void main(String[]args){
		pascal(7);
		
	}
}
