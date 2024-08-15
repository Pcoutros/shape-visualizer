/**
 * File Name: Cube.java
 * Course: CMSC335 7381
 * Date: 10/26/2023 
 * MODIFIED: 11/12/2023
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Cube that inherits from ThreeDimensionalShape. This class has one field that is a 
 * measure of the side of the Cube (all sides are equal). These field is used to calculate the volume of the Cube.
 * It has a constructor to initialize the side field and calls the constructor of ThreeDimensionalShape to 
 * initialize the volume field of the common parent class. There is constructor chaining as when the ThreeDimensionalShape
 * constructor is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 3.
 * It has a get/set method for the side field as well as a displayVolume method to print the resulting volume 
 * to the user.
 * 
 * This class is a child class of ThreeDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to the instantiation
 * of an object of this class!
 * 
 * TYPE: REGULAR CUBE
 * 
 * @author Pete Coutros
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Cube extends ThreeDimensionalShape {
	
	//Attribute
	private double side;							//used to calculate the volume of a cube
	
	/**
	 * Constructor initializes the private field of the class (side). This constructor calls the constructor
	 * of ThreeDimensionalShape using super() and passes in the calculation for volume using the cube's side
	 * to initialize the volume field of ThreeDimensionalShape. When super() is called it undergoes constructor chaining
	 * and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 3.
	 * 
	 * @param side
	 */
	public Cube(double side) {
		
		super(Math.pow(side, 3));					//volume of a cube is side^3
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
	 * This method is used to set the private field of the class (side). It will also update the volume field of
	 * ThreeDimensionalShape by calling the setVolume method and passing in the volume calculation using the new side.
	 * Validation that the side is a non-negative number must be performed prior to using this method.
	 * 
	 * @param side
	 */
	public void setSide(double side) {
		
		this.side = side;
		setVolume(Math.pow(side, 3));
	}
	
	/**
	 * This method is used to display the volume of the Cube object to the user by calling the inherited
	 * getVolume() method from ThreeDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayVolume() {
		
		System.out.printf("The volume of the Cube is %.2f \n", getVolume());
	}
	
	/**
	 * Used to get a scaling factor based on the size of the parameter. The scaling factor is used to set
	 * the size of the shape in displayImage().
	 * 
	 * ADDED: 11/12/2023
	 * 
	 * @param int parameter
	 * @return int scalingFactor
	 */
	private int getScalingFactor(int parameter) {
		int scalingFactor = 0;
		if (parameter == 10) {
			scalingFactor = 10;
		} else if (parameter == 50) {
			scalingFactor = 2;
		} else if (parameter == 100) {
			scalingFactor = 1;
		}
		return scalingFactor;
	}
	
	/**
	 * Gets an image of the shape from using the corresponding image file. The image is also scaled according to
	 * the size of the parameter to represent the different parameter options when creating the shape.
	 * 
	 * ADDED: 11/12/2023
	 * 
	 * @return ImageIcon shape
	 */
	@Override
	protected ImageIcon getImage(int firstParameter, int secondParameter) {
		int scalingFactor = getScalingFactor(firstParameter);
		ImageIcon cube = new ImageIcon(getClass().getResource("Images/Cube.png"));
		Image scaledImage = cube.getImage().getScaledInstance(300/scalingFactor, 300/scalingFactor, Image.SCALE_SMOOTH);
		cube = new ImageIcon(scaledImage);
		return cube;
	}
}
