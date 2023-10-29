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
            throw new IllegalArgumentException("[Error] 공백이 입력되었습니다.");
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
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("[ERROR] 음수가 입력되었습니다.");
        }
    }


    private static void validateBlankTryNumber(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다.");
        }
    }

    private static void validateZeroTryNumber(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 0이 입력되었습니다.");
        }
    }

    private static void validateIsIntegerTryNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }


}
