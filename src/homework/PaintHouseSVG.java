package homework;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PaintHouseSVG {

	private final static int GRID_SIZE = 90; // in pixels. the distance between two lines in the coordinate system
	private final static int DOT_SIZE = 5; // in pixels. the radius of the circles, e.g. dots we will be drawing
	private final static int FONT_SIZE = 20; // in pixels. the size of the numbers along the two axis
	private static final String LIGHT_GREY = "999999"; // Color for dots outside the house
	private static final String DARK_BLUE = "0000FF"; // Color for outline of the house
	private static final String BLACK = "#000000"; // Color for dots inside the house. i thinks it is not really needed, but...

	public static void main(String[] args) {
		// implement console input here:
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		DoublePoint[] coordinates=new DoublePoint[n];
		for (int i = 0; i < n; i++) {
			coordinates[i]=new DoublePoint(input.nextDouble(), input.nextDouble());
			input.nextLine();
		}

		// create the file here:
		PrintStream fileOutput = null;
		try {
			fileOutput = new PrintStream("house.html", "UTF-8");
			fileOutput.println("<!DOCTYPE html>");
			fileOutput.println("<title>House made by SVG</title>");
			fileOutput.println("<body>");
			fileOutput.println("<p style=\"font-family: arial; font-size: 23px; color: red\">And here is our pretty little house:</p>");
			fileOutput.println("<svg x=\"50\" y=\"50\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
			
			//print the grid:
			for (int i = 1; i <=6; i++) {
				IntPoint verticalLineStart=new IntPoint(i * GRID_SIZE, (GRID_SIZE * 7)/10);
				IntPoint verticalLineEnd=new IntPoint(i * GRID_SIZE, 6 * GRID_SIZE + (GRID_SIZE * 3)/10);
				IntPoint horizontalLineStart=new IntPoint((GRID_SIZE * 7)/10, i * GRID_SIZE);
				IntPoint horizontalLineEnd=new IntPoint(6 * GRID_SIZE + (GRID_SIZE * 3)/10, i * GRID_SIZE);
				fileOutput.println(dottedLine(verticalLineStart, verticalLineEnd));
				fileOutput.println(dottedLine(horizontalLineStart, horizontalLineEnd));
			}
			//let's do the house:
			//left rectangle:
			IntPoint origin=new IntPoint(2 * GRID_SIZE, 3 * GRID_SIZE);
			fileOutput.println(Rectangle(origin, 2 * GRID_SIZE, 2 * GRID_SIZE));
			//right rectangle:
			origin=new IntPoint(5 * GRID_SIZE, 3 * GRID_SIZE);
			fileOutput.println(Rectangle(origin, 2 * GRID_SIZE, 1 * GRID_SIZE));
			//and, finally, the roof: 
			IntPoint a=new IntPoint(2 * GRID_SIZE, 3 * GRID_SIZE);
			IntPoint b=new IntPoint(4 * GRID_SIZE, 1 * GRID_SIZE);
			IntPoint c=new IntPoint(6 * GRID_SIZE, 3 * GRID_SIZE);
			fileOutput.println(Triangle(a, b, c));
			
			//now let's print the labels of the X-axis:
			double labelX=7.5;
			for (int i = 1; i <=6; i++) {
				String label="";
				if (i % 2 != 0) {
					labelX=2.5 + labelX;
					int intLabel=(int)labelX;
					label=String.valueOf(intLabel);
				}
				else {
					labelX=2.5 + labelX;
					label=String.valueOf(labelX);
				}
				IntPoint location=new IntPoint(i * GRID_SIZE, (GRID_SIZE * 6)/10);
				fileOutput.println(Text(location, label, "middle"));
			}
			//then let's print the labels of the Y-axis:
			double labelY=1.0;
			for (int i = 1; i <=6; i++) {
				String label="";
				if (i % 2 == 0) {
					labelY=2.5 + labelY;
					int intLabel=(int)labelY;
					label=String.valueOf(intLabel);
				}
				else {
					labelY=2.5 + labelY;
					label=String.valueOf(labelY);
				}
				IntPoint location=new IntPoint((GRID_SIZE * 6)/10, i * GRID_SIZE + FONT_SIZE/3);
				fileOutput.println(Text(location, label, "end"));
			}
			//aaaand, finally finally, let's nashliapame the points!
			for (int i = 0; i < n; i++) {
				if (PointsInsideHouse.isInsideHouse(coordinates[i])) {
					int x=convertFromDoubleX(coordinates[i].getX());
					int y=convertFromDoubleY(coordinates[i].getY());
					IntPoint point=new IntPoint(x, y);
					fileOutput.println(Circle(point, DOT_SIZE, "black", "black"));
				}
				else {
					int x=convertFromDoubleX(coordinates[i].getX());
					int y=convertFromDoubleY(coordinates[i].getY());
					IntPoint point=new IntPoint(x, y);
					fileOutput.println(Circle(point, DOT_SIZE, "black", LIGHT_GREY));
				}
			}
			//and finalize the html:
			fileOutput.println("</svg>");
			fileOutput.println("</body>");
			fileOutput.println("</html>");
		} catch (IOException ex) {
			// handle me:
			ex.printStackTrace();
		} finally {
			if (fileOutput != null) {
				fileOutput.close();
			}
		}

	}
	//this method converts the X coordinates from double to int
	private static int convertFromDoubleX(double coordinateX){
		double result=coordinateX-7.5;
		result=result / 2.5;
		result=result * GRID_SIZE;
		return (int)result;
	}
	//this method converts the Y co-ordinates from double to int
	private static int convertFromDoubleY(double coordinateY){
		double result=coordinateY-1.0;
		result=result / 2.5;
		result=result * GRID_SIZE;
		return (int)result;
	}
	
	private static String dottedLine(IntPoint a, IntPoint b) {
		String result = "";
		result = "<line x1=\"" + a.getX() + "\" " + "y1=\"" + a.getY() + "\" "
				+ "x2=\"" + b.getX() + "\" " 
				+ "y2=\"" + b.getY() + "\" "
				+ "style=\"stroke:" + LIGHT_GREY + "; "
				+ "stroke-dasharray: 1 , 1;" 
				+ "\"/>";

		return result;
	}

	private static String Rectangle(IntPoint a, int height, int width) {
		String result = "";
		result = "<rect x=\"" + a.getX() + "\" " 
		+ "y=\"" + a.getY() + "\" "
				+ "height=\"" + height + "\" " 
				+ "width=\"" + width + "\" "
				+ "style=\"stroke:" + DARK_BLUE + "; " 
				+ "fill: " + LIGHT_GREY + ";" 
				+ "fill-opacity: 0.5;\""
				+ "\"/>";
		return result;
	}

	private static String Circle(IntPoint a, int radius, String strokeColor,
			String fillColor) {
		String result = "";
		result = "<circle x=\"" + a.getX() + "\" " + "cx=\"" + a.getX() + "\" "
				+ "cy=\"" + a.getY() + "\" " + "r=\"" + radius + "\" "
				+ "style=\"stroke:" + strokeColor + "; " + "fill: " + fillColor
				+ ";" + "\"/>";
		return result;
	}
	
	private static String Triangle(IntPoint a, IntPoint b, IntPoint c) {
		String result = "";
		result = "<polygon " 
				+ "points=\"" + a.getX() + "," + a.getY() + " " + b.getX() + "," + b.getY() + " "
					+ c.getX() + "," + c.getY() + "\" " 
				+ "style=\"stroke:" + DARK_BLUE + "; " 
				+ "fill:" + LIGHT_GREY + "; "
				+ "fill-opacity: 0.5;\""
				+ "/>";
		return result;
	}

	private static String Text(IntPoint a, String text, String anchor) {
		String result = "";
		result = "<text "
				+ "x=\"" + a.getX() + "\" "
				+ "y=\"" + a.getY() + "\" " 
				+ "style=\"fill:black; "
				+ "font-size:" + FONT_SIZE + "px; "
				+ "font-family:Arial; "
				+ "text-anchor:" + anchor + ";\""
				+">"
				+text
				+ "</text>";

		return result;
	}
}

