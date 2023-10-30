package racingcar.utils;

import racingcar.enums.Common;

public class Validator {
    private final static String NULL_ERROR = "[ERROR] 입력이 들어오지 않았습니다.";
    private final static String EMPTY_ERROR = "[ERROR] 공백으로 이루어져있습니다. 문자을 포함하여 작성하여 주세요.";
    private final static String SEPARATOR_ERROR = "[ERROR] 구분자가 올바르지 못한 위치에서 사용되었습니다.";
    private final static String OVER_LENGTH_ERROR = String.format("[ERROR] 이름은 %d글자 이하 여야 합니다.",
            Common.MAX_LENGTH.getIntValue());
    private final static String NUMERIC_ERROR = "[ERROR] 숫자형식이에 맞지 않는 문자를 입력하였습니다.";
    private final static String UNDER_NUMBER_ERROR = "[ERROR] 1이상의 정수를 적어주세요.";

    public void validateCarNameInput(String carNames) {
        if (isNull(carNames))
            throw new IllegalArgumentException(NULL_ERROR);
        if (isEmpty(carNames))
            throw new IllegalArgumentException(EMPTY_ERROR);
        if (isStartsWith(carNames) || isEndsWith(carNames))
            throw new IllegalArgumentException(SEPARATOR_ERROR);

        String[] carNamesArray = carNames.split(Common.SEPARATOR.getStringValue());

        for (String carName : carNamesArray) {
            if (isOverLength(carName))
                throw new IllegalArgumentException(OVER_LENGTH_ERROR);
        }
    }

    public void validateNumberOfAttemptsInput(String numberOfAttempts) {
        if (isNull(numberOfAttempts))
            throw new IllegalArgumentException(NULL_ERROR);

        if (isEmpty(numberOfAttempts))
            throw new IllegalArgumentException(EMPTY_ERROR);

        try {
            int number = Integer.valueOf(numberOfAttempts);
            if (!isPositive(number))
                throw new IllegalArgumentException(UNDER_NUMBER_ERROR);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isEmpty(String input) {
        return input.trim().isEmpty();
    }

    private boolean isStartsWith(String input) {
        return input.startsWith(Common.SEPARATOR.getStringValue());
    }

    private boolean isEndsWith(String input) {
        return input.endsWith(Common.SEPARATOR.getStringValue());
    }

    private boolean isOverLength(String input) {
        return input.length() > Common.MAX_LENGTH.getIntValue();
    }

    private boolean isPositive(int number) {
        return number < 1;
    }
}
