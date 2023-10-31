package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.constant.ExceptionConstant.*;
import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.TextConstant.COMMA;

public class MessageReceiver {

    public List<String> receiveCarNames() {
        String inputText = Console.readLine();
        List<String> carNames = Arrays.asList(inputText.split(COMMA));
        validateCarNames(carNames);

        return carNames;
    }

    public int receiveAttemptCount() {
        String inputText = Console.readLine();
        int attemptCount = Integer.parseInt(inputText);
        validateAttemptCount(attemptCount);

        return attemptCount;
    }

    private void validateCarNames(final List<String> carNames) {
        validateLength(carNames);
        validateDuplication(carNames);
    }

    private void validateLength(final List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
            }
        }
    }

    private void validateDuplication(final List<String> carNames) {
        if (isDuplication(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplication(final List<String> carNames) {
        Set<String> distinctCarNames = new HashSet<>(carNames);
        return carNames.size() != distinctCarNames.size();
    }

    private void validateAttemptCount(final int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_EXCEPTION);
        }
    }
}
