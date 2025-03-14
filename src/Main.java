import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // setting up the initial ArrayList
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        // prompting the user to enter temperatures for each day and storing them in the temperatures ArrayList
        for (String day : daysOfWeek) {
            System.out.println("Please enter the average temperature for " + day + ": ");
            double temp = scnr.nextDouble();
            temperatures.add(temp);
        }

        // loop logic for displaying daily temperature or the full week's temperature(s) based on user input
        while (true) {
            System.out.println("\nEnter a day of the week to view its temperature or type \"week\" to see all temperatures and the average for the week:");
            String userInput = scnr.next();

            if (userInput.equalsIgnoreCase("week")) {
                double totalTemp = 0;
                System.out.println("\nWeekly Temperature Report:");

                for (int i = 0; i < daysOfWeek.size(); i++) {
                    System.out.println(daysOfWeek.get(i) + ": " + temperatures.get(i) + "°F");
                    totalTemp += temperatures.get(i);
                }

                double avgTemp = totalTemp / daysOfWeek.size();
                System.out.printf("Weekly Average Temperature: %.2f°F\n", avgTemp);
                break;
            }

            // loop logic to handle error's in user input
            boolean found = false;
            for (int i = 0; i < daysOfWeek.size(); i++) {
                if (userInput.equalsIgnoreCase(daysOfWeek.get(i))) {
                    System.out.println(daysOfWeek.get(i) + "'s Temperature: " + temperatures.get(i) + "°F");
                    found = true;
                    break;
                }
            }

            // error prompt for the user if they enter the wrong data type or misspell their input
            if (!found) {
                System.out.println("Invalid input. Please enter a valid day of the week (check spelling).");
            }
        }

        scnr.close();
    }
}