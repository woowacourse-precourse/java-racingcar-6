package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ExceptionMessage;

public class InputReader {
    public String readLine() {
        String input = Console.readLine().trim();
        validateIfIsBlank(input);
        return input;
    }

    private void validateIfIsBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }
}
