package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCarName() {
        return validateBlankCarName(Console.readLine());
    }


    public static String readTryNumber() {
        return validateTryNumber(Console.readLine());
    }

    private static String validateBlankCarName(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
        return input;
    }


    private static String validateTryNumber(String input) {
        validateNullTryNumber(input);
        validateIsIntegerTryNumber(input);
        validateZeroTryNumber(input);
        validatePositiveTryNumber(input);
        return input;
    }

    private static void validatePositiveTryNumber(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateNullTryNumber(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateZeroTryNumber(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsIntegerTryNumber(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
