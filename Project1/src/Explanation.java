
public class Explanation {

	public static void main(String[]args){
		/** 
		 * set display size to n * n pixels
		 * Note: this must be called before tileBoard, otherwise it will not do its job. 
		 */
//		BoardTiling.setScreenSize(n);
		/**
         * n is the board size,and the board is square with 2 to the nth power on each side.
         * x is the x-coordinate of the hole.
         * y is the y-coordinate of the hole.
         * decoration is the boolean that will turn on or turn off the decoration,
         * true will turn on the decoration, false for no decoration.
         */
//		BoardTiling.tileBoard(n, x, y, decoration);
        /**
         * the argument is the same as above, but this will random the coordinates
         * of the hole.
         */
//		BoardTiling.tileBoard(n, decoration);
		/**
		 * 7 is the board size, with 128 tiles on each side.
		 * 30 is the x-coordinate of the hole.
		 * 25 is the y-coordinate of the hole.
		 * true is turn on the decoration.
		 */
		BoardTiling.tileBoard(7, 30, 25, true);
		/**
		 * 8 is the board size.
		 * false is no decoration.
		 * the hole coordinates will be random.
		 */
		BoardTiling.tileBoard(8, false);
	}
}
