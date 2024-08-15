/**
 * File Name: Shape.java
 * Course: CMSC335 7381
 * Date: 10/26/2023 
 * Author: Pete Coutros
 * 
 * Purpose: This abstract class defines a Shape that inherits from Object. This did not have to be explicitly written, however
 * I included it for readability. In the scope of this project, a Shape object would be useless and therefore this class was
 * declared abstract to disallow the instantiation of a Shape object. This class has one field that is a measure of the amount
 * of dimensions the shape is. It has a constructor, even though it cannot be instantiated, to initialize a common field to all
 * child classes. It has a get/set method for the field. 
 * 
 * This is a parent class to TwoDimensionalShape and ThreeDimensionalShape.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to using the class.
 * 
 * @author Pete Coutros
 */

public abstract class Shape extends Object {		//Don't need to explicitly declare extends Object
	
	//Attribute
	private int numOfDimensions;					//used to store number of dimensions of a shape
	
	/**
	 * Constructor initializes the private field of the class that is shared with all subclasses, 
	 * even though a Shape object cannot be instantiated.
	 * 
	 * @param numOfDimensions
	 */
	public Shape(int numOfDimensions) {
		
		this.numOfDimensions = numOfDimensions;
	}
	
	/**
	 * This method is used to access the private field of the class (numOfDimensions)
	 * 
	 * @return numOfDimensions
	 */
	public int getNumOfDimensions() {
		
		return numOfDimensions;
	}
	
	/**
	 * This method is used to set the private field of the class (numOfDimensions)
	 * 
	 * @param numOfDimensions
	 */
	public void setNumOfDimensions(int numOfDimensions) {
		
		this.numOfDimensions = numOfDimensions;
	}
}
