package racingcar.global.view.input;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.global.exception.ExceptionMessage.INPUT_CANNOT_BE_NULL;
import static racingcar.global.exception.ExceptionMessage.INPUT_NUMBER;

public class InputView {

    public static String stringInput() {
         String input = Console.readLine();
         if(input.isEmpty()) {
             throw new IllegalArgumentException(INPUT_CANNOT_BE_NULL.getMessage());
         }
         return input;
    }

    public static Integer integerInput() {
        String input = stringInput();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER.getMessage());
        }
    }
}
