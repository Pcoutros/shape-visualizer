/**
 * File Name: Triangle.java
 * Date: 10/26/2023 
 * MODIFIED: 11/11/2023
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Triangle that inherits from TwoDimensionalShape. This class has two fields that are a 
 * measure of the base and height of the Rectangle. These fields are used to calculate the area of the Triangle.
 * It has a constructor to initialize the base and height fields and calls the constructor of TwoDimensionalShape to 
 * initialize the area field of the common parent class. There is constructor chaining as when the TwoDimensionalShape
 * constructor is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 2.
 * It has a get/set method for the base and height fields as well as a displayArea method to print the resulting area 
 * to the user.
 * 
 * This class is a child class of TwoDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to the instantiation
 * of an object of this class!
 * 
 * TYPE: ISOSCELES TRIANGLE
 */
import java.awt.Graphics;

public class Triangle extends TwoDimensionalShape {
	
	//Attributes
	private double height;					//used to calculate the area of the Triangle
	private double base;					//used to calculate the area of the Triangle
	
	/**
	 * Constructor initializes the private fields of the class (base and height). This constructor calls the constructor
	 * of TwoDimensionalShape using super() and passes in the calculation for area using the triangle's base and height 
	 * to initialize the area field of TwoDimensionalShape. When super() is called it undergoes constructor chaining
	 * and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 2.
	 * 
	 * @param length, width
	 */
	public Triangle(double height, double base) {
		super((0.5)*(height * base));		//area of triangle is 1/2 * base * height
		this.height = height;
		this.base = base;
	}
	
	/**
	 * This method is used to access the private field of the class (height).
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * This method is used to access the private field of the class (base).
	 * 
	 * @return base
	 */
	public double getBase() {
		return base;
	}
	
	/**
	 * This method is used to set the private field of the class (height). It will also update the area field of
	 * TwoDimensionalShape by calling the setArea method and passing in the area calculation using the new height.
	 * Validation that the height is a non-negative number must be performed prior to using this method.
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
		setArea((0.5)*(height * base));
	}
	
	/**
	 * This method is used to set the private field of the class (base). It will also update the area field of
	 * TwoDimensionalShape by calling the setArea method and passing in the area calculation using the new base.
	 * Validation that the base is a non-negative number must be performed prior to using this method.
	 * 
	 * @param base
	 */
	public void setBase(double base) {
		this.base = base;
		setArea((0.5)*(height * base));
	}
	
	/**
	 * This method is used to display the area of the Triangle object to the user by calling the inherited
	 * getArea() method from TwoDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayArea() {
		System.out.printf("The area of the Triangle is %.2f \n", getArea());
	}

	/**
	 * Will draw a Triangle outline based on the height and base of the Triangle object. Will place the object
	 * with respect to the x,y coordinates of the center of the JPanel. All attributes of the object
	 * need to be converted from double to int as it is drawn based on pixels.
	 * Overrides draw() in Shape.java
	 * 
	 * Added: 11/11/2023 
	 * 
	 * @param Graphics g, int x, int y
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
		//Need to get array of coordinates as we use drawPolygon to draw triangles
		int[] xValues = {x, (x - ((int)base/2)), (x+((int)base/2))};		//top, left, and right point x-coordinates
		int[] yValues = {(y - (int)height), y, y};							//top, left, and right point y-coordinates
		g.drawPolygon(xValues, yValues, 3);
	}
}
