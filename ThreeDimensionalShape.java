/**
 * File Name: ThreeDimensionalShape.java
 * Date: 10/26/2023 
 * MODIFIED 11/12/2023
 * Author: Pete Coutros
 * 
 * Purpose: This abstract class defines a ThreeDimensionalShape that inherits from Shape. In the scope of this project, a 
 * ThreeDimensionalShape object would be useless and therefore this class was declared abstract to disallow the instantiation 
 * of a ThreeDimensionalShape object. This class has one field that is a measure of the volume of the shape.
 * It has a constructor, even though it cannot be instantiated, to initialize a common field to all child classes. 
 * It has a get/set method for the field. 
 * 
 * This class is a child class of Shape and a parent class to Sphere, Cube, Cone, Cylinder, and Torus.
 */
import javax.swing.ImageIcon;

public abstract class ThreeDimensionalShape extends Shape {

	//Attributes
	private double volume;					//used to store the volume of a ThreeDimensionalShape
	
	/**
	 * Constructor initializes the private field of the class (volume) that is shared by all subclasses,
	 * even though a ThreeDimensionalShape object cannot be instantiated. This constructor calls the constructor
	 * of Shape using super() and passes in the value 3 that represents the number of dimensions.
	 * 
	 * @param volume
	 */
	public ThreeDimensionalShape(double volume) {
		super(3);							//Shape constructor called to pass in 3 as the numOfDimensions
		this.volume = volume;
	}
	
	/**
	 * This method is used to access the private field of the class (volume)
	 * 
	 * @return volume
	 */
	public double getVolume() {
		return volume;
	}
	
	/**
	 * This method is used to set the private field of the class (volume)
	 * 
	 * @param volume
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}

	/**
	 * Abstract method to get image file, to be overriden in child classes
	 * 
	 * Added 11/12/2023
	 * 
	 * @param int firstParameter, int secondParameter
	 * @return ImageIcon shape
	 */
	protected abstract ImageIcon getImage(int firstParameter, int secondParameter);
}
