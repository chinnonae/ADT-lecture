import java.util.Scanner;


public class BoardTilingApp {

	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);


		int n = 0, x = 0, y = 0;
		int boardSize = 0;
		boolean decor = false;
		boolean pass = false;
		while(!pass){
			try{
				System.out.print("Please input the size: ");
				n = Integer.parseInt(scanner.nextLine());
				if( n < 1 ){
					throw new Exception();
				}
				pass = true;
				boardSize = (int) Math.pow(2,n);
			}catch(Exception e){
				System.out.println("Invalid input");
				pass = false;
			}
		}
		pass = false;
		while(!pass){
			try{
				System.out.print("Please input the x-coordinate (-1 if you want it to be random): ");
				x = Integer.parseInt(scanner.nextLine());
				pass = true;
				if(x == -1) x = (int)Math.floor(boardSize*Math.random());
				else if (x < -1 || x >= boardSize) throw new Exception();
			}catch(Exception e){
				System.out.println("Invalid coordinate");
				pass = false;
			}
		}

		pass = false;
		while(!pass){
			try{
				System.out.print("Please input the y-coordinate (-1 if you want it to be random): ");
				y = Integer.parseInt(scanner.nextLine());
				pass = true;
				if(y == -1) y = (int)Math.floor(boardSize*Math.random());
				else if (y < -1 || y >= boardSize) throw new Exception();
			}catch(Exception e){
				System.out.println("Invalid coordinate");
				pass = false;
			}
		}

		pass = false;
		while(!pass){
			try{
				System.out.print("Do you want decoration (Y/N): ");
				String choice = scanner.nextLine();
				if(choice.equals("Y")){
					decor = true;
				}else if(choice.equals("N")){
					decor = false;
				}else{
					pass = false;
					System.out.println("Invalid choice");
					continue;
				}
				pass = true;
			}catch(Exception e){
				System.out.println("Invalid choice");
				pass = false;
			}
		}

		System.out.print(String.format("Generate board tiling with %d tiles on each side, hole at (%d , %d) ", boardSize, x, y));
		if(decor){System.out.println("with decoration.");}
		else {System.out.println("without decoration.");}
		BoardTiling.tileBoard(n, x, y, decor);

	}
}
