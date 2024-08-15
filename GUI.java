/**
 * File Name: GUI.java
 * Course: CMSC335 7381
 * Date: 11/12/2023
 * Author: Pete Coutros
 * 
 * Purpose: The purpose of this class is to model a GUI object to be instantiated and initialized in the main. The point is
 * to display a GUI to the user so that they can select a shape they would like, its respective parameter(s), and then draw
 * that shape based on the parameters where value would equate to the amount of pixels. It displays a JFrame that is composed
 * of a JSplitePane on the left and a JPanel on the right. The JSplitPane houses a JList on the left to select the shape and
 * houses JComboBox(es) on the right to select the parameter(s) of the shape. The JPanel on the right of the JFrame is used 
 * to house the corresponding shape drawings.
 * 
 * @author Pete Coutros
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.*;

public class GUI {
	
	//Attributes
	private static final String[] OPTIONS = {"Circle", "Square", "Triangle", 
			"Rectangle", "Sphere", "Cube", "Cone", "Cylinder", "Torus"};  		//Used to name selection options in JList				
	private static final Integer[] PARAMETER_DIMENSION = {null, 10, 50, 100};	//Used for parameter options in JComboBox
	private JFrame frame;														//Main frame of GUI
	private JList<String> list;													//List of shape options		
	private JPanel parameterPanel;												//JPanel to house parameter JComboBox(es)
	private JPanel drawingPanel;												//JPanel to house drawing displays of shapes, added to frame
	private JSplitPane splitPane;												//SplitPane to house list and parameterPanel, added to frame
	private JComboBox<Integer> firstParameterComboBox;							//JComboBox for drop down list of first parameter options
	private JComboBox<Integer> secondParameterComboBox;							//JComboBox for drop down list of second parameter options
	private int firstParameter, secondParameter;								//Used to store parameter selections
	private TwoDimensionalShape twoDimensionalShape = null;						//Used polymorphically to create different TwoDimensionalShape objects
	private ThreeDimensionalShape threeDimensionalShape = null;					//Used polymorphically to create different ThreeDimensionalShape objects
	
	/**
	 * Constructor to create GUI using swing objects
	 */
	public GUI() {
		frame = new JFrame("Project 2 - Shapes");								//Instantiate and initialize JFrame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					//Close frame when exited
		
		list = new JList<String>(OPTIONS);										//Instantiate and initialize JList with shape options
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);				//Allow for only one selection from the list
		
		firstParameterComboBox = new JComboBox<Integer>(PARAMETER_DIMENSION);	//Instantiate and initialize JComboBox with first parameter dimension options
		secondParameterComboBox = new JComboBox<Integer>(PARAMETER_DIMENSION);	//Instantiate and initialize JComboBox with second parameter dimension options

		parameterPanel = new JPanel();											//Instantiate and initialize JPanel to house JComboBox(es)
	    parameterPanel.setLayout(new GridLayout(0, 2));							//Set Layout so that it reads JLabel: JComboBox \n JLabel: JComboBox
		parameterPanel.setPreferredSize(new Dimension(200, 400));				//Set Dimensions of the JPanel
		
		drawingPanel = new JPanel() {											//Instantiate and initialize JPanel to house the shape drawings
            private static final long serialVersionUID = 1L;					//Unique Identifier

			@Override
            /**
             * Overrides the paintComponent() method of JComponent to draw a shape
             * if a shape has been set. It will place the left top corner at the
             * center of the screen.
             * 
             * @param Graphics g
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);											//Call paintComponent of JComponent
                if (twoDimensionalShape != null) {									//If the shape is not null proceed
                   twoDimensionalShape.draw(g, getWidth() / 2, getHeight() / 2); 	//Call draw method of Shape Class
                }
            }
		};
		drawingPanel.setPreferredSize(new Dimension(400, 400));						//Set Dimensions of the JPanel
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, parameterPanel);	//Add list and parameterPanel to JSplitPane
		
		frame.add(splitPane, BorderLayout.WEST);									//Add splitPane on left hand side of frame
		frame.add(drawingPanel, BorderLayout.EAST);									//Add drawingPanel on right hand side of frame
		
		addFunctionalityToList();													//Give functionality to JList
		addFunctionalityToComboBox();												//Give functionality to JComboBox
	}
	
	/**
	 * Adds a ListSelectionListener to the JList. When an option is selected it 
	 * will set the shapes to null and display the parameter JComboBox(es) on 
	 * the parameterPanel by calling the updateParameterPanel() method.
	 */
	private void addFunctionalityToList() {
        list.addListSelectionListener((ListSelectionEvent e) -> {
        	setShapesToNull();													//Set shapes to Null to reset any prior drawings
            updateParameterPanel();												//Update the parameterPanel to display JComboBoxes
        });
	}
	
	/**
	 * Adds a ActionLister to the JComboBoxes. When options from the combo boxes are 
	 * selected, it stores the value in the corresponding variable(s) - 
	 * firstParameter and/or secondParameter. It also
	 * calls the processSelection() method to draw the corresponding shapes via the
	 * shape and parameter selections. This will also catch any null selections so that
	 * a shape is not created and the user is informed to select (a) parameter value(s).
	 */
	private void addFunctionalityToComboBox() {
		firstParameterComboBox.addActionListener((ActionEvent e) -> {
			try {
				firstParameter = (int) firstParameterComboBox.getSelectedItem();		//Store first parameter selection as int
				if (secondParameterComboBox.isVisible() &&
					secondParameterComboBox.getSelectedItem() == null) {				//Check if parameterPanel has a second JComboBox and if it is null					
					secondParameter = 0;												//Set secondParameter to 0
				}
		        processSelection();														//Call to process the parameter selection
			} catch (NullPointerException npe) {										//Catch a null entry from the JComboBox
				resetDrawingPanel();													//Clear the drawingPanel and inform user to select a parameter value
			}
		});
		
		secondParameterComboBox.addActionListener((ActionEvent e) -> {
			try {
				firstParameter = (int) firstParameterComboBox.getSelectedItem();		//Store first parameter selection as int
				secondParameter = (int) secondParameterComboBox.getSelectedItem();		//Store second parameter selection as int
					if (firstParameter != 0 && secondParameter != 0) {
				        processSelection();												//Call to procesSelection if both parameters are not null
					} else {
						throw new NullPointerException();								//If the parameters are 0 (default value), no selection has been made.
					}
			} catch (NullPointerException npe) {										//Catch a null entry from the JComboBox
				resetDrawingPanel();													//Clear the drawingPanel and inform user to select a parameter value
			}
		});
	}
	
	/**
	 * Will reset drawingPanel and inform user to select a parameter value from the JComboBox.
	 */
	private void resetDrawingPanel() {
		drawingPanel.removeAll();																//Remove prior content from drawingPanel
		setShapesToNull();																		//Set shapes to Null to reset any prior drawings
		drawingPanel.add(new JLabel("Please select a value from the drop down list"));			//Display message to user to select a parameter value
		drawingPanel.updateUI();																//Update the drawingPanel
	}
	
	/**
	 * Sets the two and threeDimensionalShapes to null so that they cannot be drawn on the drawingPanel.
	 * Used to remove prior shape drawings.
	 */
	private void setShapesToNull() {
		twoDimensionalShape = null;
		threeDimensionalShape = null;
	}
	
	/**
	 * Gets the number of parameters selected. A parameter will have a default value of 0 if no selection from the JComboBox is made.
	 * Will return the number of parameters populated by the user.
	 * 
	 * @param int firstParameter, int secondParameter
	 * @return
	 */
	private int getNumberOfParameters(int firstParameter, int secondParameter) {
		int count = 0;
		if (firstParameter != 0) {count = 1;}
		if (secondParameter != 0) {count = 2;}
		return count;
	}
	
	/**
	 * Processes the user shape and parameter selections to create the corresponding TwoDimensionalShape or 
	 * ThreeDimensionalShape objects from the selected parameter(s) and then draw the shape in the drawingPanel by
	 * calling either the repaint() method which will call paintComponent() for TwoDimensionalShape or by calling 
	 * display3DImage() for ThreeDimensionalShape. 
	 * 
	 * The selected parameter(s) will have default value(s) of 0 is JComboBox option is not selected. This method
	 * calls the getNumberOfParameters() method to base conrol flow off of how many parameters were populated by
	 * the user.
	 */
	private void processSelection() {
		drawingPanel.removeAll();												//Remove prior drawing/images
		if (getNumberOfParameters(firstParameter, secondParameter) == 1) {		//If only the first parameter is selected, process shapes with one parameter
			switch(list.getSelectedValue()) {									//Base flow off of user selection from JList to create corresponding shape
			case "Circle":							
				twoDimensionalShape = new Circle(firstParameter);				
				break;	
			case "Square":
				twoDimensionalShape = new Square(firstParameter);				
				break;
			case "Sphere":							
				threeDimensionalShape = new Sphere(firstParameter);			
				break;
			case "Cube":							
				threeDimensionalShape = new Cube(firstParameter);				
			break;
			}
		}	
		if (getNumberOfParameters(firstParameter, secondParameter) == 2) {				//If both parameters are selected, process shapes with two parameters
			switch(list.getSelectedValue()) {											//Base flow off of user selection from JList to create corresponding shape
			case "Triangle":
				twoDimensionalShape = new Triangle(firstParameter, secondParameter);	
				break;
			case "Rectangle":
				twoDimensionalShape = new Rectangle(firstParameter, secondParameter);	
				break;	
			case "Cone":
				threeDimensionalShape = new Cone(firstParameter, secondParameter);		
				break;
			case "Cylinder":
				threeDimensionalShape = new Cylinder(firstParameter, secondParameter);
				break;
			case "Torus":
				if (firstParameter > secondParameter) {										//Radius Major must be larger than Radius Minor
					threeDimensionalShape = new Torus(firstParameter, secondParameter);		
					break;
				} else {																	//If Radius Major is less than or equal to Radius Minor it is invalid
					resetDrawingPanel();													//Clear the drawingPanel and inform user to select a parameter value
					JOptionPane.showMessageDialog(drawingPanel, 
							new JLabel("Radius Major needs to be greater than Radius Minor!"),
							null, JOptionPane.ERROR_MESSAGE);								//Display error message wrapped in JLabel to a JOptionPane pop up
				}
			break;
			}
		}
		if (twoDimensionalShape != null) {
			drawingPanel.repaint();									//Repaint the drawingPanel by indirectly calling paintComponent() to display the 2D shape
		}
		if (threeDimensionalShape != null) {
			display3DImage(threeDimensionalShape);										//Call to display the generic image of the 3D shape
			if (list.getSelectedValue().equals("Torus")) {								//Display FYI message if shape is a torus
				JOptionPane.showMessageDialog(drawingPanel, 								
						new JLabel("Note: Torus size will not change with varying "
								+ "Radii sizes due to its complex shape."), 
								"FYI", JOptionPane.INFORMATION_MESSAGE);				//Note to the user to not expect a change in size for the Torus
			}
		}
	}
	
	/**
	 * Used to display the image of the corresponding ThreeDimensionalShape by calling the
	 * getImage() method of the shape and wrapping it in a JLabel. The image will be centered
	 * in the drawingPanel by setting the layout of the panel to FlowLayout and calculating the
	 * H/Vgaps based on the Height/Width of both the panel and the image.
	 * 
	 * @param ThreeDimensionalShape shape
	 */
	private void display3DImage(ThreeDimensionalShape shape) {
		drawingPanel.removeAll();																	//Clear any prior labels or drawings
	    JLabel image = new JLabel(shape.getImage(firstParameter, secondParameter)); 				//Get image from shape and wrap in JLabel

	    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);									//Used to center image. Needs to be stored to set H/Vgaps
	    flowLayout.setHgap((drawingPanel.getWidth() - image.getIcon().getIconWidth()) / 2);			//Set horizontal gap to center horizontally
	    flowLayout.setVgap((drawingPanel.getHeight() - image.getIcon().getIconHeight()) / 2);		//Set vertical gap to center vertically

	    drawingPanel.setLayout(flowLayout);															//Set layout of drawingPanel to the new FlowLayout
	    drawingPanel.add(image);																	//Add the image to the panel with new layout
	    drawingPanel.updateUI();																	//Update the panel to show the image
	}
	
	/**
	 * Resets the parameterPanel by removing all previous components, setting the JComboBox(es) to the first option - null,
	 * updating the parameterPanel to reflect the changes, and setting both parameter dimensions to 0 which is the default
	 * value when no selection from the JComboBox is made.
	 */
	private void resetParameterPanel() {
		parameterPanel.removeAll();							//Remove previous JLabel(s)/JComboBox(es) from parameterPanel
		
		firstParameterComboBox.setSelectedIndex(0);			//Reset the JComboBox to the first option
		secondParameterComboBox.setSelectedIndex(0);		//Reset the JComboBox to the first option
		
		parameterPanel.updateUI();							//Update the parameterPanel
		
		firstParameter = 0;									//Reset value of the first parameter to 0, which is the default value when no selection is made
		secondParameter = 0;								//Reset value of the second parameter to 0, which is the default value when no selection is made
	}
	
	/**
	 * Updates the parameterPanel with the corresponding JLabel(s) and JComboBox(es) 
	 * corresponding to the shape selected from the JList. Calls either addOneLabelAndComboBox()
	 * or addTwoLabelsAndComboBoxes() depending on the shape selected.
	 * 
	 */
	private void updateParameterPanel() {
		resetParameterPanel();								//Reset the parameterPanel
		switch(list.getSelectedValue()) {					//Base flow off of user selection from JList
		case "Circle":
			addLabelAndComboBox("Radius:", null);
			break;
		case "Square":
			addLabelAndComboBox("Side:", null);
			break;
		case "Triangle":
			addLabelAndComboBox("Height:", "Base:");
			break;
		case "Rectangle":
			addLabelAndComboBox("Length:", "Width:");
			break;
		case "Sphere":
			addLabelAndComboBox("Radius:", null);
			break;
		case "Cube":
			addLabelAndComboBox("Side:", null);
			break;
		case "Cone":
			addLabelAndComboBox("Radius:", "Height:");
			break;
		case "Cylinder":
			addLabelAndComboBox("Radius:", "Height:");
			break;
		case "Torus":
			addLabelAndComboBox("Radius Major:", "Radius Minor:");
			break;
		}
		parameterPanel.updateUI();							//Update the changes to the parameterPanel
	}
	
	/**
	 * Adds to the parameterPanel label(s) and JComboBox(es) to select the values of the parameter(s).
	 * Will add either one or two JLabels/JComboBoxes depending on the amount of parameters needed for the shape.
	 * 
	 * @param String firstParameterDescription, String secondParameterDescription
	 */
	private void addLabelAndComboBox(String firstDescription, String secondDescription) {
		parameterPanel.add(new JLabel(firstDescription));				//Add label for the parameter
		parameterPanel.add(firstParameterComboBox);						//Add JComboBox to select parameter value
		if (secondDescription != null) {
			parameterPanel.add(new JLabel(secondDescription));			//Add label for second parameter
			parameterPanel.add(secondParameterComboBox);				//Add JComboBox to select second parameter value
		}
	}
	
	/**
	 * Will make the frame visible so the user can see the GUI and interact.
	 */
	public void showGUI() {
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Main to declare, instantiate, and initialize the GUI and call the showGUI()
	 * method to display it to the user.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.showGUI();
	}

}
