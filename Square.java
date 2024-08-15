/**
 * File Name: Square.java
 * Course: CMSC335 7381
 * Date: 10/26/2023
 * MODIFIED: 11/11/2023 
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Square that inherits from TwoDimensionalShape. This class has one field that is a 
 * measure of the side of the Square. This field is used to calculate the area of the Square.
 * It has a constructor to initialize the square field and calls the constructor of TwoDimensionalShape to initialize
 * the area field of the common parent class. There is constructor chaining as when the TwoDimensionalShape constructor
 * is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 2.
 * It has a get/set method for the square field as well as a displayArea method to print the resulting area to the user.
 * 
 * This class is a child class of TwoDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * Note: This class could have been a child class of Rectangle as every square "is a kind of" rectangle.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to the instantiation
 * of an object of this class!
 * 
 * TYPE: REGULAR SQUARE
 * 
 * @author Pete Coutros
 */
import java.awt.Graphics;

public class Square extends TwoDimensionalShape {
	
	//Attribute
	private double side;					//used to calculate the area of the Square
	
	/**
	 * Constructor initializes the private field of the class (side). This constructor calls the constructor
	 * of TwoDimensionalShape using super() and passes in the calculation for area using the square's side to
	 * initialize the area field of TwoDimensionalShape. When super() is called it undergoes constructor chaining
	 * and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 2.
	 * 
	 * @param side
	 */
	public Square(double side) {
		super(Math.pow(side, 2));			//area of square is side^2
		this.side = side;
	}
	
	/**
	 * This method is used to access the private field of the class (side).
	 * 
	 * @return side
	 */
	public double getSide() {
		return side;
	}
	
	/**
	 * This method is used to set the private field of the class (side). It will also update the area field of
	 * TwoDimensionalShape by calling the setArea method and passing in the area calculation using the new side.
	 * Validation that the side is a non-negative number must be performed prior to using this method.
	 * 
	 * @param radius
	 */
	public void setSide(double side) {
		this.side = side;
		setArea(Math.pow(side, 2));
	}
	
	/**
	 * This method is used to display the area of the Square object to the user by calling the inherited
	 * getArea() method from TwoDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayArea() {
		System.out.printf("The area of the Square is %.2f \n", getArea());
	}
	
	/**
	 * Will draw a square outline based on the side of the Square object. Will place the object
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
	    	//X and Y coordinates of the JPanel are adjusted so that the center of the Square is in the
	    	//center of the JPanel, otherwise the top-left hand corner would be. Need to use drawRect and
	    	//pass side in twice.
	    	g.drawRect(((int)(x - (side/2))), ((int)(y - (side/2))), (int)side, (int)side);
    	}

}
