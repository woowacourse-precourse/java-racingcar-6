package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class NumberOfAttempts {

    private NumberOfAttempts() {

    }

    public static int input() {
        String numberOfAttempts = Console.readLine();

        return validateNumber(numberOfAttempts);
    }

    private static int validateNumber(String numberOfAttempts) {
        try {
            int numberOfAttemptsToInt = Integer.parseInt(numberOfAttempts);
            if (numberOfAttemptsToInt > 0) {
                return numberOfAttemptsToInt;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } finally {
            Console.close();
        }
    }
}
