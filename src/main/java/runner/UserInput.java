package runner;

import model.Square;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Static class to deal with Scanner and returns validated user input for the game.
 */
public class UserInput {
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Returns a numeric input that is numeric and less than maxInt.
     *
     * @param maxInt
     */
    public static int requestNumericInput(int maxInt) {
        String s = scan.nextLine();
        while (!StringUtils.isNumeric(s) || Integer.parseInt(s) > maxInt) {
            System.out.print("Invalid Input. Try Again: ");
            s = scan.nextLine();
        }

        return Integer.parseInt(s);
    }

    /**
     * Returns a valid Square.
     * Maps [A-Z] row number to [0-25] index & [1-...] to [0-...] index.
     */
    public static Square requestHitSquare() {
        System.out.print("Enter [x,y] (eg: A,10): ");
        String s = scan.nextLine();
        while (isInvalidHitSquare(s)) {
            System.out.print("Invalid Input. Try Again: ");
            s = scan.nextLine();
        }

        String[] split = s.split(",");
        return new Square(split[0].charAt(0) - 'A', Integer.parseInt(split[1]) - 1, null);
    }

    private static boolean isInvalidHitSquare(String s) {
        if (!s.contains(",")) {
            return true;
        }
        String[] split = s.split(",");
        if (split[0].length() != 1 ||
                !Character.isAlphabetic(split[0].charAt(0)) ||
                !Character.isUpperCase(split[0].charAt(0))) {
            return true;
        }
        if (!StringUtils.isNumeric(split[1]) || Integer.parseInt(split[1]) <= 0) {
            return true;
        }

        return false;
    }

    public static void requestAnyCharacter() {
        scan.nextLine();
    }
}
