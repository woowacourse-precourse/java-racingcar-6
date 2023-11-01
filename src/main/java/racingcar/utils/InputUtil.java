package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
private static final String DELIMITER = ",";

    private InputUtil() {
    }

    public static String[] readCarNames() {
        String carNamesInput = Console.readLine();
        String[] carNames = splitCarNames(carNamesInput);
        ValidationUtil.validateCarNames(carNames);
        for (String carName : carNames) {
            ValidationUtil.validateCarName(carName);
        }
        return carNames;
    }

    public static int readAttemptNumber() {
        String attemptNumberInput = Console.readLine();
        ValidationUtil.validateIsNumeric(attemptNumberInput);
        int attemptNumber = parseAttemptNumber(attemptNumberInput);
        ValidationUtil.validateAttemptNumber(attemptNumber);
        return attemptNumber;
    }

    public static String[] splitCarNames(String carNames) {
        return carNames.split(DELIMITER);
    }

    public static int parseAttemptNumber(String attemptNumber) {
        return Integer.parseInt(attemptNumber);
    }
}
