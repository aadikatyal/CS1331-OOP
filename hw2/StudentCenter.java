/**
 * I worked on the assignment alone, using only course-provided materials.
 *
 * @author Aadi Katyal
 */

package aadikatyal.cs1331.hw2;

import java.text.DecimalFormat;
import java.util.Scanner;

class StudentCenter {
    public static void main(String[] args) {
        System.out.println(
                "Welcome to the Student Center! \n" + "Activities \n" + "Bowling: $4.00 ($2 to rent bowling shoes) \n"
                        + "Billiards: $5.00 \n" + "Food \n" + "Pizza: $8.50 \n" + "Salad: $7.00 ");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\n\nWhat activity would you like to do? ");
            String activity = scanner.nextLine();

            int activityPrice = 0;

            if (activity.equalsIgnoreCase("Bowling")) {

                activityPrice = 4;

                System.out.print("Do you need bowling shoes? ");

                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    activityPrice += 2;
                }

            } else {
                activityPrice = 5;
            }

            System.out.print("\n\nWhat food would you like? ");
            String food = scanner.nextLine();

            double foodPrice = 0;

            if (food.equalsIgnoreCase("Pizza")) {
                System.out.print("Choose a topping (mushrooms: $1.5, pepperoni: $1, none: $0) ");
                String topping = scanner.nextLine();

                switch (topping.toLowerCase()) {
                    case "mushrooms": {
                        foodPrice += 1.5;
                        break;
                    }
                    case "pepperoni": {
                        foodPrice = 1;
                        break;
                    }
                    default: {
                        break;
                    }
                }

                foodPrice += 8.5;
            } else {
                foodPrice = 7;
            }

            System.out.print("\n\nWhat percentage would you like to tip for the food? ");
            double tip = scanner.nextDouble();

            if (tip < 0) {
                tip = 0.18;
            }

            System.out.print("\n\nHow many people are with you? ");
            int numPeople = scanner.nextInt();

            if (numPeople < 0) {
                numPeople = 0;
            }

            double subtotal = (activityPrice + foodPrice) * (numPeople + 1);
            double foodTip = foodPrice * (numPeople + 1) * tip;
            double total = subtotal + foodTip;

            DecimalFormat df = new DecimalFormat("####0.00");

            System.out.println("\n\nSubtotal: $" + df.format(subtotal));
            System.out.println("Food Tip: $" + df.format(foodTip));
            System.out.println("Total: $" + df.format(total));
        }
    }
}