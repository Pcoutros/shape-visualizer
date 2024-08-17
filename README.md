# Shape Visualize - A Polymorphic Project

## Description
  This project utilizes concepts in abstract classes, inheritance, and polymorphism. The front end of this application is a GUI built with Java Swing. The user is given the option to choose from several different two and three dimentional shapes. When the shape is selected, options to chose the shape's parameter or parameters are presented to the user. When the parameters are populated, the corresponding shape, and relative size, is displayed. All shape sizes, with the exception of the Torus, change with different parameter inputs. The Torus has validation checks to ensure that the Radius Major is larger than Radius Minor. Two dimensional shapes are drawn using the `draw()` method from the `java.awt.Graphics` library, whereas the three dimentional shapes are simply image files that are sized according to the entered parameter(s).

## UML

![image](https://github.com/user-attachments/assets/81c3e01d-40a9-4dac-82e9-2720711589cc)

## Assumptions

1) The parameters have the options of 10, 50, or 100 which should be thought of as small, medium, and large.
2) The shapes are defined as follows:
  `Circle: REGULAR CIRCLE
Rectangle: REGULAR RECTANGLE
Square: REGULAR SQUARE
Triangle: ISOSCELES TRIANGLE
Sphere: REGULAR SPHERE
Cube: REGULAR CUBE
Cone: RIGHT CIRCULAR CONE
Cylinder:  RIGHT CIRCULAR CYLINDER
Torus: REGULAR CIRCULAR (INCLUDING CROSS-SECTION) TORUS`

## How to Use

1) Clone the repository
2) Open terminal and change directories to the desired destination
3) Type: `git clone <repository_url>`
4) Change directory into the repository name
5) Compile the GUI.java file using: `javac GUI.java`
6) Run the program using: `java GUI.java`
