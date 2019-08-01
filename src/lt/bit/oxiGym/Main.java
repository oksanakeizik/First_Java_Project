package lt.bit.oxiGym;

import java.util.Scanner;

public class Main {

    protected static GymCustomer oCustomer;

    private static void updateProfile() {
        double dWeight, dHeight;
        int iCalories, iActivity;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your weight (kg): ");
        dWeight = input.nextDouble();
        oCustomer.setWeight(dWeight);

        System.out.println("Enter your height (cm): ");
        dHeight = input.nextDouble();
        oCustomer.setHeight(dHeight);

        System.out.println("Enter the calories burned: ");
        iCalories = input.nextInt();
        oCustomer.setCalories(iCalories);

        System.out.println("Enter physical activity time per day (minutes): ");
        iActivity = input.nextInt();
        oCustomer.setActivity(iActivity);

        oCustomer.updateBMI();
    }

    protected static void viewBMI() {
        double dBMI;

        dBMI = oCustomer.calculateBMI();

        if (dBMI == 0) {
            System.out.println("Error: Not enter body weight or height!");
            return;
        }

        System.out.println(" Your Body Mass Index: " + String.format("%.2f", dBMI));

        System.out.print("Your body weight is ");

        if (dBMI < 18.5) {
            System.out.println("underweight :( ");
        } else if (dBMI > 25) {

            System.out.println("overweight :( ");
        } else {
            System.out.println("normal weight :) ");
        }
    }

    private static boolean menu() {
        String sChoice;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Select action (1, 2, 3..or 5): ");

        System.out.println("1. Update your sports profile.");
        System.out.println("2. Calculate your Body Mass Index.");
        System.out.println("3. View your physical activity statistics.");
        System.out.println("4. Save information.");
        System.out.println("5. Exit.");

        sChoice = input.nextLine();

        switch (sChoice) {
            case "1":
                updateProfile();
                break;
            case "2":
                viewBMI();
                break;
            case "3":
                oCustomer.viewStatistics();
                break;
            case "4":
                oCustomer.save();
                break;
            case "5":
                return true;
            default:
                System.out.println("Wrong choice! Try again.");
        }

        return false;
    }

    public static void main(String[] args) {
        String sFullName;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the OxiGym! Enter your full name (Name and Surname): ");

        sFullName = input.nextLine();

        oCustomer = new GymCustomer(sFullName);

        System.out.println("Hello, " + sFullName + "!");

        // call menu continuously, until true is returned
        while (!menu()) ;

        System.out.println("Goodbye!");
    }
}
