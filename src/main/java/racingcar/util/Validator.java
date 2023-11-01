package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int MIN_TRIAL_NUMBER = 1;
    private static final String BLANK = " ";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_OF_CAR_NAME_MAX_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String ERROR_OF_CAR_NAME_MIN_LENGTH = "자동차 이름은 1자 이상만 가능합니다.";
    private static final String ERROR_OF_CAR_NAME_BLANK = "자동차 이름에 공백이 포함될 수 없습니다.";
    private static final String ERROR_OF_DUPLICATION = "중복된 자동차 이름이 존재합니다.";
    private static final String ERROR_OF_NOT_NUMBER = "숫자 형태의 값만 입력할 수 있습니다.";
    private static final String ERROR_OF_MIN_VALUE = "1보다 작은 수는 입력할 수 없습니다.";
    private Set<String> existCarNames = new HashSet<>();

    public void checkCarName(List<String> carNames) {
        for (String carName : carNames) {
            checkCarNameMaxLength(carName);
            checkCarNameMinLength(carName);
            checkCarNameBlank(carName);
            checkCarNameDuplicates(carName);
        }
    }

    public void checkVaildNum(String input) {
        isNumeric(input);
        isPositiveNum(input);
    }

    private void checkCarNameMaxLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_OF_CAR_NAME_MAX_LENGTH);
        }
    }

    private void checkCarNameMinLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_OF_CAR_NAME_MIN_LENGTH);
        }
    }

    private void checkCarNameBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_OF_CAR_NAME_BLANK);
        }
    }

    private void checkCarNameDuplicates(String carName) {
        if (!existCarNames.add(carName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_OF_DUPLICATION);
        }
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_OF_NOT_NUMBER);
        }
    }

    private void isPositiveNum(String input) {
        int number = Integer.parseInt(input);

        if (number < MIN_TRIAL_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_OF_MIN_VALUE);
        }
    }
}
