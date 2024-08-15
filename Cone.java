/**
 * File Name: Cone.java
 * Course: CMSC335 7381
 * Date: 10/26/2023 
 * MODIFIED: 11/12/2023
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Cone that inherits from ThreeDimensionalShape. This class has two fields that are a 
 * measure of the radius and height of the Cone. These fields are used to calculate the volume of the Cone.
 * It has a constructor to initialize the radius and height fields and calls the constructor of ThreeDimensionalShape to 
 * initialize the volume field of the common parent class. There is constructor chaining as when the ThreeDimensionalShape
 * constructor is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 3.
 * It has a get/set method for the radius and height fields as well as a displayVolume method to print the resulting volume
 * to the user.
 * 
 * This class is a child class of ThreeDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * Checking for non-negative field(s) does NOT occur in this class. That validation must occur prior to the instantiation
 * of an object of this class!
 * 
 * TYPE: RIGHT CIRCULAR CONE
 * 
 * @author Pete Coutros
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Cone extends ThreeDimensionalShape {
	
	//Attributes
	private double radius;										//used to calculate volume of the Cone
	private double height;										//used to calculate volume of the Cone
	
	/**
	 * Constructor initializes the private fields of the class (radius and height). This constructor calls the constructor
	 * of ThreeDimensionalShape using super() and passes in the calculation for volume using the cone's radius and height 
	 * to initialize the volume field of ThreeDimensionalShape. When super() is called it undergoes constructor chaining
	 * and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 3.
	 * 
	 * @param radius, height
	 */
	public Cone(double radius, double height) {
		
		super(Math.PI * Math.pow(radius, 2) * (height/3.0));	//volume of a Cone is π * r^2 * (h/3)
		this.radius = radius;
		this.height = height;
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
	 * This method is used to access the private field of the class (height).
	 * 
	 * @return height
	 */		
	public double getHeight() {
		
		return height;
	}
	
	/**
	 * This method is used to set the private field of the class (radius). It will also update the volume field of
	 * ThreeDimensionalShape by calling the setVolume method and passing in the volume calculation using the new radius.
	 * Validation that the radius is a non-negative number must be performed prior to using this method.
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		
		this.radius = radius;
		setVolume(Math.PI * Math.pow(radius, 2) * (height/3));
	}
	
	/**
	 * This method is used to set the private field of the class (height). It will also update the volume field of
	 * ThreeDimensionalShape by calling the setVolume method and passing in the volume calculation using the new height.
	 * Validation that the height is a non-negative number must be performed prior to using this method.
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		
		this.height = height;
		setVolume(Math.PI * Math.pow(radius, 2) * (height/3));
	}
	
	/**
	 * This method is used to display the volume of the Cone object to the user by calling the inherited
	 * getVolume() method from ThreeDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayVolume() {
		
		System.out.printf("The volume of the Cone is %.2f \n", getVolume());
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
		int firstScalingFactor = getScalingFactor(firstParameter);
		int secondScalingFactor = getScalingFactor(secondParameter);
		ImageIcon cone = new ImageIcon(getClass().getResource("Images/Cone.png"));
		Image scaledImage = cone.getImage().getScaledInstance(300/firstScalingFactor, 300/secondScalingFactor, Image.SCALE_SMOOTH);
		cone = new ImageIcon(scaledImage);
		return cone;
	}

}
