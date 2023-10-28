package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Typing {

    private Typing() {
    }

    public static List<String> inputCarName() {
        String carName = Console.readLine();
        List<String> carNameList = Arrays.asList(carName.split(","));
        if (hasCarNameOverFiveOrUnderOne(carNameList)) {
            throw new IllegalArgumentException();
        }

        return carNameList;
    }
    private static boolean hasCarNameOverFiveOrUnderOne(List<String> carNameList) {
        for (String s : carNameList) {
            if (s.length() > 5 || s.length() < 1) {
                return true;
            }
        }
        return false;
    }

    public static int inputNumberOfAttempts () {
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