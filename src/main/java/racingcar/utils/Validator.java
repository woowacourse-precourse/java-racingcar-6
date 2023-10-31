package racingcar.utils;

import racingcar.enums.Common;

public class Validator extends CommonValidator{
    private final static String NULL_ERROR = "[ERROR] 입력이 들어오지 않았습니다.";
    private final static String EMPTY_ERROR = "[ERROR] 공백으로 이루어져있습니다. 문자을 포함하여 작성하여 주세요.";
    private final static String ANY_EMPTY_ERROR = "[ERROR] 이름들 중 공백으로 이루어진 곳이 있습니다.";
    private final static String SEPARATOR_ERROR = "[ERROR] 구분자가 올바르지 못한 위치에서 사용되었습니다.";
    private final static String OVER_LENGTH_ERROR = String.format("[ERROR] 이름은 %d글자 이하 여야 합니다.",
            Common.NAME_MAX_LENGTH.getIntValue());
    private final static String NUMERIC_ERROR = "[ERROR] 숫자형식이에 맞지 않는 문자를 입력하였습니다.";
    private final static String UNDER_NUMBER_ERROR = "[ERROR] 양수를 적어주세요.";

    public static void validateCarNameInput(String carNames) {
        if (carNames == null)
            throw new IllegalArgumentException(NULL_ERROR);
        if (carNames.isBlank())
            throw new IllegalArgumentException(EMPTY_ERROR);

        String[] carNamesArray = carNames.split(Common.SEPARATOR.getStringValue());

        if (!isPositive(carNamesArray.length))
            throw new IllegalArgumentException(SEPARATOR_ERROR);

        for (String carName : carNamesArray) {
            if (carName.isBlank())
                throw new IllegalArgumentException(ANY_EMPTY_ERROR);
            if (isOverMaxLength(carName))
                throw new IllegalArgumentException(OVER_LENGTH_ERROR);
        }
    }

    public static void validateNumberOfAttemptsInput(String numberOfAttempts) {
        if (numberOfAttempts == null)
            throw new IllegalArgumentException(NULL_ERROR);
        if (numberOfAttempts.isBlank())
            throw new IllegalArgumentException(EMPTY_ERROR);

        if (!isNumeric(numberOfAttempts))
            throw new IllegalArgumentException(NUMERIC_ERROR);
        if (!isPositive(numberOfAttempts))
            throw new IllegalArgumentException(UNDER_NUMBER_ERROR);
    }
}
