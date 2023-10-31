package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.constants.MessageType;
import racingcar.global.exception.ErrorMessage;
import racingcar.global.exception.RaceException;

public final class View {

    private static void printlnMessage(final MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    private static String readLine() {
        String userInput = Console.readLine();
        Validator.validateNonBlankInput(userInput);
        return userInput;
    }

    class Validator {
        private static void validateNonBlankInput(String input) {
            if (input.isBlank()) {
                throw RaceException.of(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }
    }
}
