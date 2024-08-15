/**
 * File Name: Circle.java
 * Date: 10/26/2023 
 * MODIFIED: 11/11/2023
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Circle that inherits from TwoDimensionalShape. This class has one field that is a 
 * measure of the radius of the Circle. This field is used to calculate the area of the Circle.
 * It has a constructor to initialize the radius field and calls the constructor of TwoDimensionalShape to initialize
 * the area field of the common parent class. There is constructor chaining as when the TwoDimensionalShape constructor
 * is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 2.
 * It has a get/set method for the radius field as well as a displayArea method to print the resulting area to the user.
 * 
 * This class is a child class of TwoDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to the instantiation
 * of an object of this class!
 * 
 * TYPE: REGULAR CIRCLE
 */
import java.awt.Graphics;

public class Circle extends TwoDimensionalShape {
	
	//Attribute
	private double radius;						//used to calculate the area of the Circle
	
	/**
	 * Constructor initializes the private field of the class (radius). This constructor calls the constructor
	 * of TwoDimensionalShape using super() and passes in the calculation for area using the circle's radius to
	 * initialize the area field of TwoDimensionalShape. When super() is called it undergoes constructor chaining
	 * and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 2.
	 * 
	 * @param radius
	 */
	public Circle(double radius) {
		
		super(Math.PI * Math.pow(radius, 2));	//area of Circle is π * r^2
		this.radius = radius;
	}
	
	/**
	 * This method is used to access the private field of the class (radius).
	 * 
	 * @return radius
	 */
	public double getRadius() {
		
		return radius;
	}
	
	/**
	 * This method is used to set the private field of the class (radius). It will also update the area field of
	 * TwoDimensionalShape by calling the setArea method and passing in the area calculation using the new radius.
	 * Validation that the radius is a non-negative number must be performed prior to using this method.
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		
		this.radius = radius;
		setArea(Math.PI * Math.pow(radius, 2));
	}
	
	/**
	 * This method is used to display the area of the Circle object to the user by calling the inherited
	 * getArea() method from TwoDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayArea() {
		
		System.out.printf("The area of the Circle is %.2f \n", getArea());
	}

	/**
	 * Will draw a circle outline based on the radius of the Circle object. Will place the object
	 * with respect to the x,y coordinates of the center of the JPanel. All attributes of the object
	 * need to be converted from double to int as it is drawn based on pixels.
	 * Overrides draw() in Shape.java
	 * 
	 * Added: 11/11/2023
	 * dr
	 * @param Graphics g, int x, int y
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
	    	//X and Y coordinates of the JPanel are adjusted so that the center of the Circle is in the
	    	//center of the JPanel, otherwise the top-left hand corner would be. Need to multiply radius
	    	//by two to get the diameter as that is how drawOval works for circles.
	        g.drawOval(((int)(x-radius)), ((int)(y-radius)), ((int)(2 * radius)), ((int)(2 * radius)));
	}

}
