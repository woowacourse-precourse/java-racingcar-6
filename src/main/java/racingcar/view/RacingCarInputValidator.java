package racingcar.view;

import java.util.List;

public class RacingCarInputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final int MAX_ATTEMPT_NUMBER = 200_000_000;
    private static final String AVAILABLE_CHARACTER_REGEX = "[a-zA-Z0-9가-힣]*";
    private static final String DUPLICATED_CAR_NAMES_EXCEPTION = "각 자동차의 이름은 고유해야 합니다.";
    private static final String MAX_CAR_NAME_EXCEPTION = "자동차 이름은 최소 1자 이상 최대 5자 이하만 가능합니다.";
    private static final String AVAILABLE_CHARACTER_EXCEPTION = "자동차 이름은 한글, 영어, 숫자만 가능합니다.";
    private static final String ATTEMPT_NOT_POSITIVE_NUMBER_EXCEPTION = "시도 횟수는 1 이상 2억 이하의 숫자만 입력 가능합니다.";
    private static final String ATTEMPT_NOT_NUMBER_EXCEPTION = "입력값이 숫자가 아닙니다.";

    public void validateCarNames(List<String> carNames) {
        validateDuplicated(carNames);
        for (String carName : carNames) {
            validateLength(carName);
            validateCharacter(carName);
        }
    }

    private void validateDuplicated(List<String> carNames) {
        int distinctCount = (int) carNames.stream()
                .distinct()
                .count();
        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES_EXCEPTION);
        }
    }

    private void validateLength(String carName) {
        if (carName.isEmpty() || carName.isBlank() || MAX_CAR_NAME_LENGTH < carName.length()) {
            throw new IllegalArgumentException(MAX_CAR_NAME_EXCEPTION);
        }
    }

    private void validateCharacter(String carName) {
        if (!carName.matches(AVAILABLE_CHARACTER_REGEX)) {
            throw new IllegalArgumentException(AVAILABLE_CHARACTER_EXCEPTION);
        }
    }

    public void validateAttemptCounts(String attempt) {
        int attemptNumber = convertAttemptCounts(attempt);
        if (attemptNumber < MIN_ATTEMPT_NUMBER || MAX_ATTEMPT_NUMBER < attemptNumber) {
            throw new IllegalArgumentException(ATTEMPT_NOT_POSITIVE_NUMBER_EXCEPTION);
        }
    }

    private static int convertAttemptCounts(String attempt) {
        int attemptNumber;
        try {
            attemptNumber = Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_NOT_NUMBER_EXCEPTION);
        }
        return attemptNumber;
    }
}
