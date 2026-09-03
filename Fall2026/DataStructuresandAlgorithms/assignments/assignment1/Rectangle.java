
// Name:        Jake Cashion
// Class:       Section W01
// Term:        Fall 2025
// Instructor:    Maxwell Bradley
// Assignment:    1
// IDE Name:    Visual Studio Code

public class Rectangle {
    // Default values for rectangle objects
    
    // default rectangle width value
    private double width = 1.00;
    //default rectangle height value
    private double height = 1.00;

    // Methods

    // Getter methods
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return (width+height)*2;
    }
    // Print out Rectangle details

    public String PrintRectangle(String name) {
        return "Rectangle " +name+ " is "+this.width+ " units wide and " +this.height+ " units high.";
    }
    // Constructor methods

    // default constructor
    public Rectangle() {}

        // Constructor that will allow the user to input a double for the height and width
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }



}

