package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.InputValidator;

public final class InputDevice {
    private final static String DELIMITER = ",";
    private final static String INVALID_NUMBER_MESSAGE = "숫자 외에 값은 입력할 수 없습니다.";

    private InputDevice() {
    }

    public static List<String> inputNamesWithCommaDelimiter() {
        OutputDevice.printInputNamesMessage();

        List<String> names = Arrays.asList(Console.readLine().split(DELIMITER, -1));
        InputValidator.checkEmptyAndBlankNames(names);

        return names;
    }

    public static int inputAttemptCount() {
        OutputDevice.printInputAttemptCountMessage();

        String attemptCountStr = Console.readLine();
        try {
            int attemptCount = Integer.parseInt(attemptCountStr);
            InputValidator.checkPositiveValue(attemptCount);

            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

}
