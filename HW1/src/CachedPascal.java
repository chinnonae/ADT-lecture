import java.util.ArrayList;


public class CachedPascal {

	static ArrayList<Triple> cached = new ArrayList<Triple>();
	
	public static void pascal(int n){
		System.out.println(solvePascal(n-1, n-1));
	}
	
	public static StringBuilder solvePascal(int line, int row){
		StringBuilder builder;
		if(line == 0){
			builder = new StringBuilder();
		}else if(row > 0){
			builder = solvePascal(line, row - 1);
		} else {
			builder = solvePascal(line - 1, line - 1);
		}
		
		int comb = combination(line, row);
		if(line == 0){
			builder.append(comb);
		}else if(row > 0){
			builder.append(comb+" ");
		} else {
			builder.append("\n"+comb+" ");
		}
		return builder;
	}
	
	public static int combination(int n, int r){
		if( r == 0 || r == n) return 1;
		
		int cache;
		if(r >= (n+1)/2)
			cache = getCache(n, r - (n/2));
		else 
			cache = getCache(n, r);
		
		if(cache > 0){
			return cache;
		}
		
		
		int comb = combination(n-1, r) + combination(n-1,r-1);
		cached.add(new Triple(n, r, comb));
		return comb;
	}
	
	public static int getCache(int n, int r){
		if(cached.size() == 0) return -1;
		for(int i = cached.size() - 1 ; i >= 0 ; i--){
			Triple cache = cached.get(i);
			if(cache.n == n && cache.r == r)
				return cache.v;
		}
		return -1;
	}
	
	public static void main(String[]args){
		long start = System.nanoTime();
		pascal(132);
		long time = System.nanoTime() - start;
		System.out.println("\n" + time + " ns.");
		System.out.println(time*(Math.pow(10, -9)) + "s");
	}
}
