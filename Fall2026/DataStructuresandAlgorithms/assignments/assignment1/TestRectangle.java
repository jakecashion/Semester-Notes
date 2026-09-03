import java.util.Scanner;

// Name:        Jake Cashion
// Class:       Section W01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    1
// IDE Name:    Visual Studio Code

public class TestRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test data - Create rectangle objects
        Rectangle myRectangle = new Rectangle(1.0, 1.0);

        // Allows the user to enter data for yourRectangle
        System.out.println("Input the width and height values of yourRectangle. First, enter the value of the width and hit enter\n");
        System.out.print("Enter width: ");
        double userWidth = scanner.nextDouble();
        System.out.print("Enter height: ");
        double userHeight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create new rectangle with user input
        Rectangle yourRectangle = new Rectangle(userWidth, userHeight);

        // Display myRectangle
        System.out.println();
        System.out.println("Test data:  myRectangle1:");
        System.out.println("-------------");
        System.out.println("Width:      " + String.format("%.2f", myRectangle.getWidth()));
        System.out.println("Height:     " + String.format("%.2f", myRectangle.getHeight()));
        System.out.println("Area:       " + String.format("%.2f", myRectangle.getArea()));
        System.out.println("Perimeter:  " + String.format("%.2f", myRectangle.getPerimeter()));
        System.out.println();
        System.out.println(myRectangle.PrintRectangle("myRectangle"));
        System.out.println();

        // Display yourRectangle
        System.out.println("yourRectangle:");
        System.out.println("---------------");
        System.out.println("Width:      " + String.format("%.2f", yourRectangle.getWidth()));
        System.out.println("Height:     " + String.format("%.2f", yourRectangle.getHeight()));
        System.out.println("Area:       " + String.format("%.2f", yourRectangle.getArea()));
        System.out.println("Perimeter:  " + String.format("%.2f", yourRectangle.getPerimeter()));
        System.out.println();
        System.out.println(yourRectangle.PrintRectangle("yourRectangle"));
        System.out.println();


        // Test all class functions on at least one object
        System.out.println();
        System.out.println("Testing method getWidth() on object yourRectangle: " + yourRectangle.getWidth());
        System.out.println("Testing method getHeight() on object yourRectangle: " + yourRectangle.getHeight());
        System.out.println("Testing method getArea() on object yourRectangle: " + yourRectangle.getArea());
        System.out.println("Testing method getPerimeter() on object yourRectangle: " + yourRectangle.getArea());

        String name = "yourRectangle";
        System.out.println("Testing method getPerimeter() on object yourRectangle: " + yourRectangle.PrintRectangle(name));
        scanner.close();
    }
}
