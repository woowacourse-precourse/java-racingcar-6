package racingcar;

import static racingcar.Constant.BLANK_CAR_NAME_MESSAGE;
import static racingcar.Constant.BLANK_SPACE;
import static racingcar.Constant.DUPLICATE_CAR_NAME_MESSAGE;
import static racingcar.Constant.INVALID_NUMERIC_INPUT_MESSAGE;
import static racingcar.Constant.MAX_CAR_NAME_LENGTH;
import static racingcar.Constant.MINIMUM_ATTEMPT_COUNT_REQUIRED_MESSAGE;
import static racingcar.Constant.MIN_ATTEMPT_COUNT;
import static racingcar.Constant.OVER_MAX_LENGTH_MESSAGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserInputException {
    public void validateUniqueCarName(String[] carNames) {
        // 자동차 이름 중복 검사
        if (duplicateCarName(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
        }
    }

    private boolean duplicateCarName(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        // 중복된 값이 Set에 추가되지 않으면 true를 반환
        return Arrays.stream(carNames)
                .anyMatch(carName -> !uniqueCarNames.add(carName));
    }

    public void validateBlankCarName(String[] carNames) {
        // 자동차 이름 공백 검사
        if (containsBlankName(carNames)) {
            throw new IllegalArgumentException(BLANK_CAR_NAME_MESSAGE);
        }
    }

    private boolean containsBlankName(String[] carNames) {
        return Arrays.stream(carNames)
                .anyMatch(carName -> carName.contains(BLANK_SPACE));
    }

    public void validateCarNameLength(String[] carNames) {
        // 자동차 이름 길이 검사
        if (overMaxLength(carNames)) {
            throw new IllegalArgumentException(OVER_MAX_LENGTH_MESSAGE);
        }
    }

    private boolean overMaxLength(String[] carNames) {
        return Arrays.stream(carNames)
                .anyMatch(carName -> carName.length() > MAX_CAR_NAME_LENGTH);
    }

    public int isIntegerAttemptCount(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT_MESSAGE);
        }
    }

    public void validateAttemptCountRange(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(MINIMUM_ATTEMPT_COUNT_REQUIRED_MESSAGE);
        }
    }
}
