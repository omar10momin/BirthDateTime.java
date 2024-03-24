import java.util.Scanner;

public class SafeInput {
    /**
     * Get an integer within a specified inclusive range from the user.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user (without the range)
     * @param low     the low value for the input range
     * @param high    the high value for the input range
     * @return an integer input from the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInput = 0;
        boolean isValidInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();
                if (userInput >= low && userInput <= high) {
                    isValidInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next(); // Read and discard the invalid input
            }
        } while (!isValidInput);

        // Clear the buffer
        pipe.nextLine();

        return userInput;
    }
}
