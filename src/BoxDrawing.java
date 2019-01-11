/**
 * 
 * @author Ting Yin Stanley Ho
 * 
 *         Pre-conditions: Assume that height or width cannot be 0 or 1 and
 *         therefore has to be at least > 1
 *         
 *         Note: Text file encoding was set to UTF-8 as the default for eclipse was Cp1252 by default
 */
public class BoxDrawing {

	/*
	 * A method to print out a box using box drawing characters from Ascii 
	 */
	public static void drawBox(int height, int width) {
		char[][] grid = new char[height][width];
		char topLeft = '\u250D'; // ┍
		char topRight = '\u2511'; // ┑
		char bottomLeft = '\u2515'; // ┕
		char bottomRight = '\u251A';// ┚
		char horizontalEdge = '\u2500'; // -
		char verticalEdge = '\u2502'; // |

		if (height < 2 || width < 2) {
			throw new IllegalArgumentException("Please input a value of height or width that is bigger than 1");
			
		} else {
			// The grid corners will always be the same 'coordinates' relative to the height
			// and width given.
			grid[0][0] = topLeft;
			grid[0][width - 1] = topRight;
			grid[height - 1][0] = bottomLeft;
			grid[height - 1][width - 1] = bottomRight;

			// for loop to print out the vertical lines
			for (int i = 1; i < height - 1; i++) {
				grid[i][0] = verticalEdge;
				grid[i][width - 1] = verticalEdge;
			}
			// for loop to print out the horizontal lines
			for (int i = 1; i < width - 1; i++) {
				grid[0][i] = horizontalEdge;
				grid[height - 1][i] = horizontalEdge;
			}

			// printing 'grid' (2d array)
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {

					System.out.print(grid[i][j] + "   ");// space of 3 horizontally between symbols
				}
				System.out.println(); //space of 2 vertically between symbols
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		drawBox(5,4);
		

	}
}
