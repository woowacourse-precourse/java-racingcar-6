package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class InputDevice {
    private final static String DELIMITER = ",";
    private final static String INVALID_NUMBER_MESSAGE = "숫자 외에 값은 입력할 수 없습니다.";

    private InputDevice() {
    }

    public static List<String> inputNamesWithCommaDelimiter() {
        String[] names = Console.readLine().split(DELIMITER, -1);
        return Arrays.asList(names);
    }

    public static int inputAttemptCount() {
        String attemptCount = Console.readLine();
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

}
