package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorMessages;
import racingcar.constant.Messages;
import racingcar.constant.NumberLimits;

public class InputView {
    public static String inputCarNames() {
        System.out.println(Messages.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static int inputAttemptCount() {
        System.out.println(Messages.INPUT_ATTEMPT_COUNT);
        try {
            int attemptCount = Integer.parseInt(Console.readLine());
            validateInput(attemptCount);
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR);
        }
    }

    private static void validateInput(int attemptCount) {
        if (attemptCount < NumberLimits.MIN_ATTEMPTCOUNT_NUM) {
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_ATTEMPTCOUNT_ERROR);
        }
    }

}
