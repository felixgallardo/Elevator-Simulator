
/**
 *
 * @author Felix Gallardo
 * ID: 108496237
 * Homework #3
 * CSE 214: Recitation Section 1
 * Recitation TA: Mohammad Mahdi Javanmard
 * Grading TA: Jian Xu
 *
 * The Analyzer class imports the scanner class, creates a scanner object and
 * later prompts the user for information, assigning that information to the
 * request, floorNum, numOfElevators and simLength variables. When the user
 * is entering information, there's a try-catch to check if the values being
 * entered are illegal.
 *
 * */

import java.util.Scanner;

public class Analyzer {
    /**
     * The beginning of the driver class, where the scanner object is created and the information
     * for the sim method is gathered.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        /**
         Here, we prompt the user for the request, floorNum, numOfElevators
         and the simLength, which we later pass to the Simulator's sim method to run the
         simulation.
         **/

       System.out.println("Please enter the probability of arrival for Requests: ");
        double request = userInput.nextDouble();
        try {
            if (request < 0 || request > 1) {
                throw new IllegalArgumentException("The probability must be between 1 and 0.");
            }
            System.out.println("Please enter the number of floors: ");
            int floorNum = userInput.nextInt();
            if (floorNum < 0) {
                throw new IllegalArgumentException("The number of floors can't be a negative number.");
            }
            System.out.println("Please enter the number of elevators: ");
            int numOfElevators = userInput.nextInt();
            if (numOfElevators < 0) {
                throw new IllegalArgumentException("The number of elevators can't be a negative number.");
            }
            System.out.println("Please enter the length of the simulator (in time units)");
            int simLength = userInput.nextInt();
            if (simLength < 0) {
                throw new IllegalArgumentException("The simulation can't run for a negative amount of time.");
            }

            System.out.println(Simulator.sim(request, floorNum, numOfElevators, simLength));

        } catch (IllegalArgumentException fe) {
            System.out.println(fe.getMessage());
        }
    }
}