package racingcar.presentation;

import racingcar.constant.RacingGameConstant;

public class InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = RacingGameConstant.MAX_CAR_NAME_LENGTH;
    private static final InputValidator instance = new InputValidator();

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        return instance;
    }

    public void validateCarNames(String carNamesInput) {
        validateCarNamesNotEmpty(carNamesInput);
        String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            validateSingleCarName(carName);
        }
    }

    private void validateCarNamesNotEmpty(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름들이 제대로 입력되지 않았습니다.");
        }
    }

    private void validateSingleCarName(String carName) {
        if (carName.trim().isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("잘못된 자동차 이름이 있습니다: " + carName);
        }
    }

    public void validateTryCount(String tryCountInput) {
        validateTryCountNotEmpty(tryCountInput);
        int tryCount = convertToPositiveNumber(tryCountInput);
        ensureIsPositive(tryCount);
    }

    private void validateTryCountNotEmpty(String tryCountInput) {
        if (tryCountInput == null || tryCountInput.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 회수가 제대로 입력되지 않았습니다.");
        }
    }

    private int convertToPositiveNumber(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자로 입력해야 합니다.");
        }
    }

    private void ensureIsPositive(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
        }
    }
}