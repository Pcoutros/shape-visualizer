/**
 * File Name: ThreeDimensionalShape.java
 * Date: 10/26/2023 
 * MODIFIED: 11/11/2023
 * Author: Pete Coutros
 * 
 * Purpose: This abstract class defines a TwoDimensionalShape that inherits from Shape. In the scope of this project, a 
 * TwoDimensionalShape object would be useless and therefore this class was declared abstract to disallow the instantiation 
 * of a TwoDimensionalShape object. This class has one field that is a measure of the area of the shape.
 * It has a constructor, even though it cannot be instantiated, to initialize a common field to all child classes. 
 * It has a get/set method for the field. 
 * 
 * This class is a child class of Shape and a parent class to Circle, Rectangle, Square, and Triangle.
 */
import java.awt.Graphics;

public abstract class TwoDimensionalShape extends Shape {
	
	//Attribute
	private double area;						//used to store the area of a TwoDimensionalShape
	
	/**
	 * Constructor initializes the private field of the class (area) that is shared by all subclasses,
	 * even though a TwoDimensionalShape object cannot be instantiated. This constructor calls the constructor
	 * of Shape using super() and passes in the value 2 that represents the number of dimensions.
	 * 
	 * @param volume
	 */
	public TwoDimensionalShape(double area) {
		super(2);								//Shape constructor called to pass in 2 as the numOfDimensions
		this.area = area;
	}
	
	/**
	 * This method is used to access the private field of the class (area)
	 * 
	 * @return area
	 */	
	public double getArea() {
		return area;
	}
	 
	/**
	 * This method is used to set the private field of the class (area)
	 * 
	 * @param area
	 */
	public void setArea(double area) {
		this.area = area;
	}
	
	/**
	 * Abstract method to be overridden by child shape classes to draw their respective shape outlines.
	 * 
	 * Added: 11/11/2023
	 * 
	 * @param Graphics g, int x, int y
	 */
	public abstract void draw(Graphics g, int x, int y);
}
