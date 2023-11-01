package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.error.ErrorType.INVALID_ATTEMPT_COUNT_INPUT;
import static racingcar.error.ErrorType.INVALID_CAR_NAME_LENGTH;

public class GameInputView {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String[] carNames = Console.readLine().split(CAR_NAME_DELIMITER);
        validateAllCarNamesFiveOrLess(carNames);
        return Arrays
                .stream(carNames)
                .toList();
    }

    public static int inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);

        String input = Console.readLine();
        int attemptCount;
        try {
            attemptCount = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_INPUT.getMessage(), ex);
        }
        validateAttemptCountPositive(attemptCount);
        return attemptCount;
    }

    private static void validateAllCarNamesFiveOrLess(String... carNames) {
        boolean existsOverFive = Arrays
                .stream(carNames)
                .anyMatch(s -> s.length() > 5);
        if (existsOverFive) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateAttemptCountPositive(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_INPUT.getMessage());
        }
    }
}
