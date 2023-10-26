package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ErrorMessage;
import racingcar.Message;

public class InputView {
    public static String inputString(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        validateBlank(inputValue);
        return inputValue;
    }

    public static int inputInteger(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        validateBlank(inputValue);
        validateInteger(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK);
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER);
        }
    }
}
