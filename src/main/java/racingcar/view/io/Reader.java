package racingcar.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.RacingException;

public class Reader {
    public List<String> readStrings(String delimiter) {
        String input = Console.readLine();
        validateNotEndDelimiter(input, delimiter);
        return Arrays.stream(input.split(delimiter))
                .toList();
    }

    private void validateNotEndDelimiter(String input, String delimiter) {
        if (input.isBlank() || endWithDelimiter(input, delimiter)) {
            throw RacingException.INVALID_INPUT_FORMAT.makeException();
        }
    }

    private static boolean endWithDelimiter(String input, String delimiter) {
        return input.substring(input.length() - 1).equals(delimiter);
    }

    public int readInteger() {
        String input = Console.readLine();
        return parseInt(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw RacingException.NOT_NUMBER.makeException();
        }
    }
}
