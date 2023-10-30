package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class NumberOfAttempts {

    private NumberOfAttempts() {

    }

    public static int input() {
        try {
            String numberOfAttempts = Console.readLine();
            int numberOfAttemptsToInt = Integer.parseInt(numberOfAttempts);
            if (isNumberOfAttemptsValid(numberOfAttemptsToInt)) {
                return numberOfAttemptsToInt;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } finally {
            Console.close();
        }
    }

    private static boolean isNumberOfAttemptsValid(int numberOfAttemptsToInt) {
        if (numberOfAttemptsToInt > 0) {
            return true;
        }
        return false;
    }
}
