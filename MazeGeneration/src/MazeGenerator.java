import java.util.HashMap;
import java.util.Scanner;

public class MazeGenerator {

	private static boolean maze[][];
	private static int row, column;
	private static int[] path;
	private static HashMap<Integer, Pair> map;
	
	private static class Pair{
		private int x, y;
		public Pair(int x, int y){this.x = x; this.y = y;}
	}
	
	public static void readInput(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Row : ");
		row = Integer.parseInt(scanner.nextLine());
		System.out.print("Column : ");
		column = Integer.parseInt(scanner.nextLine());
		System.out.println();
	}
	
	public void generateMaze(){
		for(int i = 0; i < path.length; i++) path[i] = -1;
		
	}
	
	public static void main(String[]args){
		if(args.length == 0){
			readInput();
		}else{
			row = Integer.parseInt(args[0]);
			column = Integer.parseInt(args[1]);
		}
		maze = new boolean[row*2+1][column*2+1];
		map = new HashMap(row*column);
		int counter = 0;
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				if(i == 0 || i % 2 == 0
						|| j == 0 || j % 2 == 0){
					maze[i][j] = true;
				}else{
					map.put(counter++, new Pair(i, j));
				}
			}
		}
		printMaze();
	}
	
	public static void printMaze(){
		for(boolean[] a: maze){
			for(boolean b: a){
				if(b){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
