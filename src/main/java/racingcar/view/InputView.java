package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 공백이 입력되었습니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 음수가 입력되었습니다.";
    private static final String ZERO_ERROR_MESSAGE = "[ERROR] 0이 입력되었습니다.";
    private static final String NON_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값이 입력되었습니다.";
    private static final String BLANK = "";
    private static final String ZERO = "0";

    private static final int NEGATIVE_NUMBER = -1;

    public static String readCarName() {
        return validateBlankCarName(Console.readLine());
    }

    public static String readTryNumber() {
        return validateTryNumber(Console.readLine());
    }

    private static String validateBlankCarName(String input) {
        if (input.equals(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
        return input;
    }


    private static String validateTryNumber(String input) {
        validateBlankTryNumber(input);
        validateIsIntegerTryNumber(input);
        validateZeroTryNumber(input);
        validatePositiveTryNumber(input);
        return input;
    }

    private static void validatePositiveTryNumber(String input) {
        if (Integer.parseInt(input) <= NEGATIVE_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }


    private static void validateBlankTryNumber(String input) {
        if (input.equals(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateZeroTryNumber(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(ZERO_ERROR_MESSAGE);
        }
    }

    private static void validateIsIntegerTryNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_ERROR_MESSAGE);
        }
    }


}
