
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class BoxDrawingTest {

	private char topLeft;
	private char topRight;
	private char bottomLeft;
	private char bottomRight;
	private char horizontalEdge;
	private char verticalEdge;

	@Before
	public void setUp() {
		topLeft = '\u250D'; // ┍
		topRight = '\u2511'; // ┑
		bottomLeft = '\u2515'; // ┕
		bottomRight = '\u251A';// ┚
		horizontalEdge = '\u2500'; // -
		verticalEdge = '\u2502'; // |
	}

	/**
	 * By Making an char array and putting the right box symbol in the respective
	 * position in the array we can compare it to the method used in BoxDrawing
	 * Class. This specific test is for the 4x4 box.
	 * 
	 */
	@Test
	public void testFor4x4Box() {

		char[][] expectedBox = new char[4][4];
		expectedBox[0][0] = topLeft;
		expectedBox[0][1] = horizontalEdge;
		expectedBox[0][2] = horizontalEdge;
		expectedBox[0][3] = topRight;
		expectedBox[1][0] = verticalEdge;
		expectedBox[2][0] = verticalEdge;
		expectedBox[3][0] = bottomLeft;
		expectedBox[3][1] = horizontalEdge;
		expectedBox[3][2] = horizontalEdge;
		expectedBox[3][3] = bottomRight;
		expectedBox[1][3] = verticalEdge;
		expectedBox[2][3] = verticalEdge;

		BoxDrawing boxDrawing = new BoxDrawing();
		char[][] actual = boxDrawing.drawBox(4, 4);

		assertArrayEquals(expectedBox, actual);
	}

	@Test
	public void testForException() {

	}

	/**
	 * Test method to print out the base case which is a 2x2 box
	 * 
	 */
	@Test
	public void testPrintMethod() {

		char[][] expectedBox = new char[2][2];
		expectedBox[0][0] = topLeft;
		expectedBox[0][1] = topRight;
		expectedBox[1][0] = bottomLeft;
		expectedBox[1][1] = bottomRight;

		ByteArrayOutputStream printedContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(printedContent));
		BoxDrawing boxDrawing = new BoxDrawing();
		char[][] actual = boxDrawing.drawBox(2, 2);
		boxDrawing.print2DArray(actual);

		StringWriter expectedStringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(expectedStringWriter);

		printWriter.println("┍  ┑  ");
		printWriter.println();
		printWriter.println("┕  ┚  ");
		printWriter.println();
		printWriter.close();
		String expected = expectedStringWriter.toString();

		assertEquals(expected, printedContent.toString());

	}
}
