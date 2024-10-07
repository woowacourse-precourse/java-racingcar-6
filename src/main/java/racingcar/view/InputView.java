package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ErrorMessage;

public class InputView {

    public static String inputString(String message) {
        System.out.println(message);
        String inputValue = Console.readLine().trim();
        validataBlank(inputValue);
        return inputValue;
    }


    public static int inputInteger(String message) {
        System.out.println(message);
        String inputValue = Console.readLine().trim();
        validataBlank(inputValue);
        validataInteger(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validataBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK);
        }
    }
    private static void validataInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER);
        }
    }





}
