/**
 * File Name: Rectangle.java
 * Date: 10/26/2023 
 * MODIFIED: 11/11/2023
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Rectangle that inherits from TwoDimensionalShape. This class has two fields that are a 
 * measure of the length and width of the Rectangle. These fields are used to calculate the area of the Rectangle.
 * It has a constructor to initialize the length and width fields and calls the constructor of TwoDimensionalShape to 
 * initialize the area field of the common parent class. There is constructor chaining as when the TwoDimensionalShape
 * constructor is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 2.
 * It has a get/set method for the length and width fields as well as a displayArea method to print the resulting area 
 * to the user.
 * 
 * This class is a child class of TwoDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to the instantiation
 * of an object of this class!
 * 
 * TYPE: REGULAR RECTANGLE
 */
import java.awt.Graphics;

public class Rectangle extends TwoDimensionalShape {
	
	//Attributes
	private double length;						//used to calculate the area of the Rectangle
	private double width;						//used to calculate the area of the Rectangle
	
	/**
	 * Constructor initializes the private fields of the class (length and width). This constructor calls the constructor
	 * of TwoDimensionalShape using super() and passes in the calculation for area using the rectangle's length and width 
	 * to initialize the area field of TwoDimensionalShape. When super() is called it undergoes constructor chaining
	 * and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 2.
	 * 
	 * @param length, width
	 */
	public Rectangle(double length, double width) {
		
		super(length * width);					//area of rectangle is length * width
		this.length = length;
		this.width = width;
	}
	
	/**
	 * This method is used to access the private field of the class (length).
	 * 
	 * @return length
	 */
	public double getLength() {
		
		return length;
	}
	
	/**
	 * This method is used to access the private field of the class (width).
	 * 
	 * @return width
	 */
	public double getWidth() {
		
		return width;
	}
	
	/**
	 * This method is used to set the private field of the class (length). It will also update the area field of
	 * TwoDimensionalShape by calling the setArea method and passing in the area calculation using the new length.
	 * Validation that the length is a non-negative number must be performed prior to using this method.
	 * 
	 * @param length
	 */
	public void setLength(double length) {
		
		this.length = length;
		setArea(length * width);
	}
	
	/**
	 * This method is used to set the private field of the class (width). It will also update the area field of
	 * TwoDimensionalShape by calling the setArea method and passing in the area calculation using the new width.
	 * Validation that the width is a non-negative number must be performed prior to using this method.
	 * 
	 * @param width
	 */
	public void setWidth(double width) {
		
		this.width = width;
		setArea(length * width);
	}
	
	/**
	 * This method is used to display the area of the Rectangle object to the user by calling the inherited
	 * getArea() method from TwoDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayArea() {
		
		System.out.printf("The area of the Rectangle is %.2f \n", getArea());
	}

	/**
	 * Will draw a rectangle outline based on the length and width of the Rectangle object. Will place the object
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
    	//X and Y coordinates of the JPanel are adjusted so that the center of the Rectangle is in the
    	//center of the JPanel, otherwise the top-left hand corner would be. 
		g.drawRect(((int)(x-length/2)), ((int)(y-width/2)), (int)length, (int)width);	
	}

}
