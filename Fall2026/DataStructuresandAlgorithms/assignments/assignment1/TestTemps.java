import java.util.Scanner;

// Name:        Jake Cashion
// Class:       Section W01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    1
// IDE Name:    Visual Studio Code

public class TestTemps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test data - Create DailyTemps objects
        DailyTemps myTemps = new DailyTemps(65, 68, 72, 70, 75, 78, 80);

        // Allows the user to enter data for yourTemps
        System.out.println("Input the temperature values for each day of the week.\n");
        int[] userTemps = new int[7];
        String[] dayPrompts = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int i = 0; i < dayPrompts.length; i++) {
            System.out.print("Enter temperature for " + dayPrompts[i] + ": ");
            userTemps[i] = scanner.nextInt();
        }

        // Create new DailyTemps with user input
        DailyTemps yourTemps = new DailyTemps(userTemps[0], userTemps[1], userTemps[2], userTemps[3], userTemps[4], userTemps[5], userTemps[6]);

        // Display myTemps
        System.out.println();
        System.out.println("Test data: myTemps:");
        System.out.println("-------------------");
        System.out.println(myTemps.printTemps());
        System.out.println("Days below freezing: " + myTemps.Freezing());
        System.out.println("Warmest day:        " + myTemps.Warmest());
        System.out.println();

        // Display yourTemps object and testing Dailytemps.java
        System.out.println("yourTemps:");
        System.out.println("----------");
        System.out.println(yourTemps.printTemps());
        System.out.println("Testing Freezing(): " + yourTemps.Freezing());
        System.out.println("Testing Warmest():        " + yourTemps.Warmest());
        System.out.println();
        System.out.println("Testing method setTemp():");
        System.out.print("Enter a day name to update: ");
        scanner.nextLine();
        String dayToUpdate = scanner.nextLine();
        System.out.print("Enter new temperature: ");
        int newTemp = scanner.nextInt();
        yourTemps.setTemp(dayToUpdate, newTemp);

        System.out.println();
        System.out.println("Updated yourTemps:");
        System.out.println("------------------");
        System.out.println(yourTemps.printTemps());
        System.out.println("Days below freezing: " + yourTemps.Freezing());
        System.out.println("Warmest day:        " + yourTemps.Warmest());

        scanner.close();
    }
}
