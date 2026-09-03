// Name:        Jake Cashion
// Class:       Section W01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    1
// IDE Name:    Visual Studio Code

public class DailyTemps {
    private int[] temperatures;
    private String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public DailyTemps(int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        temperatures = new int[7];
        temperatures[0] = monday;
        temperatures[1] = tuesday;
        temperatures[2] = wednesday;
        temperatures[3] = thursday;
        temperatures[4] = friday;
        temperatures[5] = saturday;
        temperatures[6] = sunday;
    }

    public void setTemp(String day, int temperature) {
        for (int i = 0; i < dayNames.length; i++) {
            if (dayNames[i].equalsIgnoreCase(day)) {
                temperatures[i] = temperature;
                return;
            }
        }
    }

    public String Freezing() {
        int count = 0;
        for (int temp : temperatures) {
            if (temp < 32) {
                count++;
            }
        }
        return "The number of freezing days is "+count+" day(s).";
    }

    public String Warmest() {
        int maxTemp = temperatures[0];
        int maxIndex = 0;

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > maxTemp) {
                maxTemp = temperatures[i];
                maxIndex = i;
            }
        }

        return "The warmest day of the week is "+dayNames[maxIndex]+".";
    }

    public String printTemps() {
        StringBuilder result = new StringBuilder();
        result.append("Daily Temperatures:\n");
        result.append("-------------------\n");
        for (int i = 0; i < dayNames.length; i++) {
            result.append(String.format("%-12s %d\n", dayNames[i], temperatures[i]));
        }
        return result.toString();
    }
}
