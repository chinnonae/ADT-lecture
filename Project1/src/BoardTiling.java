import java.awt.Color;


public class BoardTiling {

	public static void tileBoard(int size){
		double n = Math.pow(2, size);
		int x = (int) Math.floor(Math.random()*n);
		int y = (int) Math.floor(Math.random()*n);
		tileBoard(size, x, y);
	}
	
	public static void tileBoard(int size, int x, int y){
		size = (int) Math.pow(2, size);
		StdDraw.setPenRadius(0.01);
		StdDraw.show();
		StdDraw.setXscale(0, size);
		StdDraw.setYscale(0, size);
		StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
		placeL(x+0.5,y+0.5,0,0,size/2);
	}
	
	private static void placeL(double holeX, double holeY, int xbot, int ybot, int size){
		int cenX = xbot + size;
		int cenY = ybot + size;
		if(size <= 0){
			return ;
		}
		StdDraw.setPenColor(randomColor());
		if(holeX > cenX && holeY > cenY){
			drawL(cenX,cenY,0);
			placeL(cenX-0.5, cenY-0.5, cenX-size, cenY-size, size/2);
			placeL(cenX+0.5, cenY-0.5, cenX, cenY-size, size/2);
			placeL(holeX, holeY, cenX, cenY, size/2);
			placeL(cenX-0.5, cenY+0.5, cenX-size, cenY, size/2);
		}else if(holeX < cenX && holeY > cenY){
			drawL(cenX,cenY,270);
			placeL(cenX+0.5, cenY-0.5, cenX, cenY-size,size/2);
			placeL(cenX-0.5, cenY-0.5, cenX-size, cenY-size, size/2);
			placeL(holeX, holeY,  cenX-size, cenY, size/2);
			placeL(cenX+0.5, cenY+0.5, cenX, cenY, size/2);
		}else if(holeX < cenX && holeY < cenY){
			drawL(cenX,cenY,180);
			placeL(cenX+0.5, cenY+0.5, cenX, cenY, size/2);
			placeL(cenX+0.5, cenY+0.5, cenX, cenY-size,size/2 );
			placeL(holeX, holeY, cenX-size, cenY-size, size/2);
			placeL(cenX-0.5, cenY-0.5, cenX-size, cenY, size/2);
		}else if(holeX > cenX && holeY < cenY ){
			drawL(cenX,cenY,90);
			placeL(cenX-0.5, cenY+0.5, cenX-size, cenY, size/2 );
			placeL(holeX, holeY, cenX, cenY-size, size/2);
			placeL(cenX-0.5, cenY-0.5, cenX-size, cenY-size, size/2);
			placeL(cenX+0.5, cenY+0.5, cenX, cenY, size/2);
		}
		
		
	}
	
	private static void drawL(int x, int y, int degree){
		switch(degree){
		case 90:
			StdDraw.line(x,y,x+1,y);
			StdDraw.line(x+1,y,x+1,y+1);
			StdDraw.line(x+1, y+1, x-1, y+1);
			StdDraw.line(x-1,y+1,x-1,y-1);
			StdDraw.line(x-1,y-1,x,y-1);
			StdDraw.line(x,y-1,x,y);
			break;
		case 180:
			StdDraw.line(x,y,x-1,y);
			StdDraw.line(x-1,y,x-1,y+1);
			StdDraw.line(x-1,y+1,x+1,y+1);
			StdDraw.line(x+1,y+1,x+1,y-1);
			StdDraw.line(x+1, y-1, x, y-1);
			StdDraw.line(x, y-1, x, y);
			break;
		case 270:
			StdDraw.line(x,y,x,y+1);
			StdDraw.line(x,y+1,x+1,y+1);
			StdDraw.line(x+1,y+1,x+1,y-1);
			StdDraw.line(x+1,y-1,x-1,y-1);
			StdDraw.line(x-1,y-1,x-1,y);
			StdDraw.line(x-1,y,x,y);
			break;
		default:
			StdDraw.line(x, y, x, y+1);
			StdDraw.line(x, y+1, x-1, y+1);
			StdDraw.line(x-1, y+1, x-1, y-1);
			StdDraw.line(x-1, y-1, x+1, y-1);
			StdDraw.line(x+1, y-1, x+1, y);
			StdDraw.line(x+1, y, x, y);
		}
	}
	
	public static Color randomColor(){
		int r = (int)Math.floor(Math.random()*150);
		int g = (int)Math.floor(Math.random()*150);
		int b = (int)Math.floor(Math.random()*150);
		return new Color(r,g,b);
		
	}
	
	public static void main(String[]args){
		StdDraw.setCanvasSize(1000,1000);
		tileBoard(4);
//		tileBoard(4,15,0);
	}
}
