import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program uses recursion to reverse,
 * a set of strings.
 *
 * @author  Melody Berhane
 * @version 1.0
 *
 * @since 2023-04-16.
 */

public final class Factorial {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String line = sc.nextLine();
                try {
                    // Parse the input as double.
                    final int newLine = Integer.parseInt(line);

                    // Declare variable.
                    final int aStr = newLine;

                    // Call function.
                    final int factorialNum = recFactorial(aStr);

                    // Write to console.
                    write.print("The factorial of " + aStr);
                    write.println(" is " + factorialNum);
                } catch (NumberFormatException error) {
                    // Displays error to user if input is not a valid int.
                    write.print("Error: Invalid, \""
                            + line + "\" is not a valid number.");
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * calculate recursion.
    *
    * @param num passed
    * @return recFactorial.
    */

    public static int recFactorial(int num) {
        // Calculates factorial.
        if (num <= 1) {
            return 1;
        } else {
            // Calls function recursively.
            return recFactorial(num - 1) * num;
        }
    }
}
