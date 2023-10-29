package racingcar.view;

import static racingcar.exception.InputErrorCode.BLANK_INPUT;
import static racingcar.exception.InputErrorCode.NEGATIVE_INTEGER_INPUT;
import static racingcar.exception.InputErrorCode.NOT_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return getInput();
    }

    public static int inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);

        final int attemptCount = convertToInteger(getInput());
        validateNotNegative(attemptCount);

        return attemptCount;
    }

    private static String getInput() {
        final String input = Console.readLine();
        validateNotBlank(input);

        return input;
    }

    private static void validateNotBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new InputException(BLANK_INPUT);
        }
    }

    private static void validateNotNegative(final int value) {
        if (value < 0) {
            throw new InputException(NEGATIVE_INTEGER_INPUT);
        }
    }

    private static int convertToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new InputException(NOT_INTEGER_INPUT);
        }
    }

}
