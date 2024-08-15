/**
 * File Name: Torus.java
 * Course: CMSC335 7381
 * Date: 10/26/2023 
 * MODIFIED: 11/12/2023
 * Author: Pete Coutros
 * 
 * Purpose: This class defines a Torus that inherits from ThreeDimensionalShape. This class has two fields that are a 
 * measure of the radiusMajor and radiusMinor of the Torus. These fields are used to calculate the volume of the Torus.
 * It has a constructor to initialize the radiusMajor and radiusMinor fields and calls the constructor of ThreeDimensionalShape
 * to initialize the volume field of the common parent class. There is constructor chaining as when the ThreeDimensionalShape
 * constructor is called, it calls the constructor of the Shape class to initialize the numberOfDimensions to 3.
 * It has a get/set method for the radius and height fields as well as a displayVolume method to print the resulting volume
 * to the user.
 * 
 * This class is a child class of ThreeDimensionalShape and therefore a grandchild class of Shape. This class has no children.
 * 
 * NOTE: radiusMajor must be larger than radiusMinor
 * 
 * Checking for non-negative field(s) or that radiusMajor is greater than radiusMinor does NOT occur in this class. 
 * That validation must occur prior to the instantiation of an object of this class!
 * 
 * TYPE: REGULAR CIRCULAR (INCLUDING CROSS-SECTION) TORUS
 * 
 * @author Pete Coutros
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Torus extends ThreeDimensionalShape {
	
	//Attributes
	private double radiusMajor;															//used to calculate volume of the torus
	private double radiusMinor;															//used to calculate volume of the torus
	
	/**
	 * Constructor initializes the private fields of the class (radiusMajor and Radius Minor). This constructor calls the 
	 * constructor of ThreeDimensionalShape using super() and passes in the calculation for volume using the cylinder's 
	 * radiusMajor and radiusMinor to initialize the volume field of ThreeDimensionalShape. When super() is called it undergoes 
	 * constructor chaining and calls the constructor of the grandparent class Shape to initialize the numberOfDimensions to 3.
	 * 
	 * @param radiusMajor, radiusMinor
	 */
	public Torus(double radiusMajor, double radiusMinor) {
		
		super((Math.PI * Math.pow(radiusMinor, 2)) * (2 * Math.PI * radiusMajor));		//volume of Torus is (π * r^2) * (2 * π * R)
		this.radiusMajor = radiusMajor;
		this.radiusMinor = radiusMinor;
	}
	
	/**
	 * This method is used to access the private field of the class (radiusMajor).
	 * 
	 * @return radiusMajor
	 */	
	public double getRadiusMajor() {
		
		return radiusMajor;
	}
	
	/**
	 * This method is used to access the private field of the class (radiusMinor).
	 * 
	 * @return radiusMinor
	 */	
	public double getRadiusMinor() {
		
		return radiusMinor;
	}
	
	/**
	 * This method is used to set the private field of the class (radiusMajor). It will also update the volume field of
	 * ThreeDimensionalShape by calling the setVolume method and passing in the volume calculation using the new radiusMajor.
	 * Validation that the radiusMajor is a non-negative number and is greater than radiusMinor must be performed prior to 
	 * using this method.
	 * 
	 * @param radiusMajor
	 */
	public void setRadiusMajor(double radiusMajor) {
		
		this.radiusMajor = radiusMajor;
		setVolume((Math.PI * Math.pow(radiusMinor, 2)) * (2 * Math.PI * radiusMajor));
	}
	
	/**
	 * This method is used to set the private field of the class (radiusMinor). It will also update the volume field of
	 * ThreeDimensionalShape by calling the setVolume method and passing in the volume calculation using the new radiusMinor.
	 * Validation that the radiusMinor is a non-negative number and is less than radiusMajor must be performed prior to 
	 * using this method.
	 * 
	 * @param radiusMinor
	 */
	public void setRadiusMinor(double radiusMinor) {
		
		this.radiusMinor = radiusMinor;
		setVolume((Math.PI * Math.pow(radiusMinor, 2)) * (2 * Math.PI * radiusMajor));
	}
	
	/**
	 * This method is used to display the volume of the Torus object to the user by calling the inherited
	 * getVolume() method from ThreeDimensionalShape. It formats the output to 2 decimal places.
	 * 
	 */
	public void displayVolume() {
		
		System.out.printf("The volume of the Torus is %.2f \n", getVolume());
	}
	
	/**
	 * Gets an image of the shape from using the corresponding image file. The Torus cannot be simply adjusted
	 * using a scaling factor.
	 * 
	 * ADDED: 11/12/2023
	 * 
	 * @return ImageIcon shape
	 */
	@Override
	protected ImageIcon getImage(int firstParameter, int secondParameter) {
		ImageIcon torus = new ImageIcon(getClass().getResource("Images/Torus.png"));
		Image scaledImage = torus.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		torus = new ImageIcon(scaledImage);
		return torus;
	}

}
