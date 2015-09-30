import java.awt.Color;


public class BoardTiling {
	
	static final int DEFAULT_SCREEN_SIZE = 800; 
	static int screenSize = DEFAULT_SCREEN_SIZE;
	static BoardTiling instance;
	static double penSize;
	static int boardSize;
	
	public static void tileBoard(int size){
		double n = Math.pow(2, size);
		int x = (int) Math.floor(Math.random()*n);
		int y = (int) Math.floor(Math.random()*n);
		tileBoard(size, x, y);
	}
	
	private BoardTiling(){
		init();
	}
	
	private void init(){
		setScreenSize(DEFAULT_SCREEN_SIZE);
	}
	
	public static void setScreenSize(int size){
		screenSize = size;
		StdDraw.setCanvasSize(screenSize, screenSize);
	}
	
	public static BoardTiling getInstance(){
		if(instance == null){
			instance = new BoardTiling();
		}
		return instance;
	}
	
	public static void tileBoard(int size, int x, int y){
		boardSize = (int) Math.pow(2, size);
		penSize = (((double)boardSize)+screenSize)/(boardSize*screenSize)*0.4;
		StdDraw.setPenRadius(penSize);
		StdDraw.show();
		StdDraw.setXscale(0, boardSize);
		StdDraw.setYscale(0, boardSize);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
		placeL(x+0.5,y+0.5,0,0,boardSize/2);
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
			if(size > 1){
				placeL(cenX-0.5, cenY-0.5, cenX-size, cenY-size, size/2);
				placeL(cenX+0.5, cenY-0.5, cenX, cenY-size, size/2);
				placeL(holeX, holeY, cenX, cenY, size/2);
				placeL(cenX-0.5, cenY+0.5, cenX-size, cenY, size/2);
			}
		}else if(holeX < cenX && holeY > cenY){
			drawL(cenX,cenY,270);
			if(size > 1){
				placeL(cenX+0.5, cenY-0.5, cenX, cenY-size,size/2);
				placeL(cenX-0.5, cenY-0.5, cenX-size, cenY-size, size/2);
				placeL(holeX, holeY,  cenX-size, cenY, size/2);
				placeL(cenX+0.5, cenY+0.5, cenX, cenY, size/2);
			}
		}else if(holeX < cenX && holeY < cenY){
			drawL(cenX,cenY,180);
			if(size > 1){
				placeL(cenX+0.5, cenY+0.5, cenX, cenY, size/2);
				placeL(cenX+0.5, cenY+0.5, cenX, cenY-size,size/2 );
				placeL(holeX, holeY, cenX-size, cenY-size, size/2);
				placeL(cenX-0.5, cenY-0.5, cenX-size, cenY, size/2);
			}
		}else if(holeX > cenX && holeY < cenY ){
			drawL(cenX,cenY,90);
			if(size > 1){
				placeL(cenX-0.5, cenY+0.5, cenX-size, cenY, size/2 );
				placeL(holeX, holeY, cenX, cenY-size, size/2);
				placeL(cenX-0.5, cenY-0.5, cenX-size, cenY-size, size/2);
				placeL(cenX+0.5, cenY+0.5, cenX, cenY, size/2);
			}
		}
		
		
	}
	
	private static void drawL(double x, double y, int degree){
		double shift = penSize*boardSize/0.8/4;
		switch(degree){
		case 90:
			StdDraw.line(x-shift,y+shift,x+1-shift,y+shift);
			StdDraw.line(x+1-shift,y+shift,x+1-shift,y+1-shift);
			StdDraw.line(x+1-shift, y+1-shift, x-1+shift, y+1-shift);
			StdDraw.line(x-1+shift,y+1-shift,x-1+shift,y-1+shift);
			StdDraw.line(x-1+shift,y-1+shift,x-shift,y-1+shift);
			StdDraw.line(x-shift,y-1+shift,x-shift,y+shift);
			break;
		case 180:
			StdDraw.line(x+shift,y+shift,x-1+shift,y+shift);
			StdDraw.line(x-1+shift,y+shift,x-1+shift,y+1-shift);
			StdDraw.line(x-1+shift,y+1-shift,x+1-shift,y+1-shift);
			StdDraw.line(x+1-shift,y+1-shift,x+1-shift,y-1+shift);
			StdDraw.line(x+1-shift, y-1+shift, x+shift, y-1+shift);
			StdDraw.line(x+shift, y-1+shift, x+shift, y+shift);
			break;
		case 270:
			StdDraw.line(x+shift,y-shift,x+shift,y+1-shift);
			StdDraw.line(x+shift,y+1-shift,x+1-shift,y+1-shift);
			StdDraw.line(x+1-shift,y+1-shift,x+1-shift,y-1+shift);
			StdDraw.line(x+1-shift,y-1+shift,x-1+shift,y-1+shift);
			StdDraw.line(x-1+shift,y-1+shift,x-1+shift,y-shift);
			StdDraw.line(x-1+shift,y-shift,x+shift,y-shift);
			break;
		default:
			StdDraw.line(x-shift, y-shift, x-shift, y+1-shift);
			StdDraw.line(x-shift, y+1-shift, x-1+shift, y+1-shift);
			StdDraw.line(x-1+shift, y+1-shift, x-1+shift, y-1+shift);
			StdDraw.line(x-1+shift, y-1+shift, x+1-shift, y-1+shift);
			StdDraw.line(x+1-shift, y-1+shift, x+1-shift, y-shift);
			StdDraw.line(x+1-shift, y-shift, x-shift, y-shift);
		}
	}
	
	public static Color randomColor(){
		int r = 70+(int)Math.floor(Math.random()*150);
		int g = 70+(int)Math.floor(Math.random()*150);
		int b = 70+(int)Math.floor(Math.random()*150);
		return new Color(r,g,b,240);
		
	}
	
	public static void main(String[]args){
		setScreenSize(1000);
		tileBoard(7);
		
	}
	
}