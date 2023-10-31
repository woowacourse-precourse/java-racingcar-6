package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static racingcar.constant.ExceptionConstant.*;
import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.TextConstant.COMMA;

public class MessageReceiver {

    public List<String> receiveCarNames() {
        String inputText = validateReadLine();
        List<String> carNames = Arrays.asList(inputText.split(COMMA));
        validateCarNames(carNames);

        return carNames;
    }

    public int receiveAttemptCount() {
        String inputText = validateReadLine();
        int attemptCount = parseInteger(inputText);
        validateAttemptCount(attemptCount);

        return attemptCount;
    }

    // validate ReadLine
    private String validateReadLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(READ_LINE_EXCEPTION);
        }
    }

    // validate CarName
    private void validateCarNames(final List<String> carNames) {
        validateCarNamesLength(carNames);
        validateDuplication(carNames);
    }

    private void validateCarNamesLength(final List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(final String carName) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
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

    // validate AttemptCount
    private int parseInteger(final String inputText) {
        try {
            return Integer.parseInt(inputText);
        }  catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private void validateAttemptCount(final int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_EXCEPTION);
        }
    }
}
