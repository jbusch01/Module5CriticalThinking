import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        // ArrayLists for days of the week and temperatures for each day
        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Setting up the initial ArrayList
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        // Prompting the user to enter temperatures for each day and storing them in the temperatures ArrayList
        for (String day : daysOfWeek) {
            boolean validTemp = false;
            while (!validTemp) {
                try {
                    System.out.println("Please enter the average temperature for " + day + ": ");
                    double temp = scnr.nextDouble();

                    if (temp < -150.0 || temp > 150.0) {
                        System.out.println("The temperature is outside the expected range (-150°F to 150°F). Please enter a valid temperature.");
                    } else {
                        temperatures.add(temp);
                        validTemp = true;
                    }

                } catch (Exception e) {
                    System.out.println("Invlaid input. Please enter a numeric value for the temperature.");
                    scnr.nextLine(); // To clear the newLine
                }
            }
        }

        // Loop logic for displaying daily temperature or the full week's temperature(s) based on user input
        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("\nEnter a day of the week to view its temperature, or type \"week\" to see all temperatures and the average for the week:");
            System.out.println("Type \"exit\" to quit the program.");
            String userInput = scnr.next();
            boolean found = false;

            if (userInput.equalsIgnoreCase("week")) {
                double totalTemp = 0;
                System.out.println("\nWeekly Temperature Report:\n");

                for (int day = 0; day < daysOfWeek.size(); day++) {
                    System.out.println(daysOfWeek.get(day) + ": " + temperatures.get(day) + "°F");
                    totalTemp += temperatures.get(day);
                }

                double avgTemp = totalTemp / daysOfWeek.size();
                System.out.printf("\nWeekly Average Temperature: %.2f°F\n", avgTemp);
                found = true;
            }

            else if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting program. Goodbye!\n");
                continueProgram = false;
            
            } else {

                // Loop logic to handle error's in user input
                for (int day = 0; day < daysOfWeek.size(); day++) {
                    if (userInput.equalsIgnoreCase(daysOfWeek.get(day))) {
                        System.out.println("\n" + daysOfWeek.get(day) + "'s Temperature: " + temperatures.get(day) + "°F");
                        found = true;
                        break;
                    }
                }            

                // Error message for the user if they enter the wrong data type or misspell their input
                if (!found) {
                    System.out.println("\nInvalid input. Please enter a valid day of the week (check spelling).");
                }
            }
        }

        scnr.close();
    }
}