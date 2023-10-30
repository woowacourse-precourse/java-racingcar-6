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
        if (carNames == null)
            throw new IllegalArgumentException(NULL_ERROR);
        if (carNames.trim().isEmpty())
            throw new IllegalArgumentException(EMPTY_ERROR);
        if (carNames.startsWith(Common.SEPARATOR.getStringValue())
                || carNames.endsWith(Common.SEPARATOR.getStringValue()))
            throw new IllegalArgumentException(SEPARATOR_ERROR);

        String[] carNamesArray = carNames.split(Common.SEPARATOR.getStringValue());

        for (String carName : carNamesArray) {
            if (carName.length() > Common.MAX_LENGTH.getIntValue())
                throw new IllegalArgumentException(OVER_LENGTH_ERROR);
        }
    }

    public void validateNumberOfAttemptsInput(String numberOfAttempts) {
        if (numberOfAttempts == null)
            throw new IllegalArgumentException(NULL_ERROR);

        if (numberOfAttempts.trim().isEmpty())
            throw new IllegalArgumentException(EMPTY_ERROR);

        try {
            int number = Integer.valueOf(numberOfAttempts);
            if (number < 1)
                throw new IllegalArgumentException(UNDER_NUMBER_ERROR);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }
}
