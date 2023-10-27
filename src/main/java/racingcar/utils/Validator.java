package racingcar.utils;

import racingcar.constants.Constants;

public class Validator {
    private final static String NULL_ERROR = "[ERROR] 입력이 들어오지 않았습니다.";
    private final static String EMPTY_ERROR = "[ERROR] 공백으로 이루어져있습니다. 문자을 포함하여 작성하여 주세요.";
    private final static String SEPARATOR_ERROR = "[ERROR] 구분자가 올바르지 못한 위치에서 사용되었습니다.";
    private final static String OVER_LENGTH_ERROR = String.format("[ERROR] 이름은 %d글자 이하 여야 합니다.",
            Constants.MAX_LENGTH.getIntValue());
    private final static String NUMERIC_ERROR = "[ERROR] 숫자형식이에 맞지 않는 문자를 입력하였습니다.";
    private final static String UNDER_NUMBER_ERROR = "[ERROR] 1이상의 정수를 적어주세요.";
    
    private final static String ONLY_NUMBER_REGEX = "^[^0-9]*$";

    public void validateCarNameInput(String carNames) {
        if (carNames == null)
            throw new IllegalArgumentException(NULL_ERROR);
        if (carNames.trim().isEmpty())
            throw new IllegalArgumentException(EMPTY_ERROR);
        if (carNames.startsWith(Constants.SEPARATOR.getStringValue())
                || carNames.endsWith(Constants.SEPARATOR.getStringValue()))
            throw new IllegalArgumentException(SEPARATOR_ERROR);

        String[] carNamesArray = carNames.split(Constants.SEPARATOR.getStringValue());

        for (String carName : carNamesArray) {
            if (carName.length() > Constants.MAX_LENGTH.getIntValue())
                throw new IllegalArgumentException(OVER_LENGTH_ERROR);
        }
    }

    public void validatenumberOfAttempsInput(String numberOfAttemps) {
        try {
            if (numberOfAttemps == null)
                throw new IllegalArgumentException(NULL_ERROR);
            if (numberOfAttemps.trim().isEmpty())
                throw new IllegalArgumentException(EMPTY_ERROR);
            if (numberOfAttemps.matches(ONLY_NUMBER_REGEX))
                throw new IllegalArgumentException(NUMERIC_ERROR);
            int number = Integer.valueOf(numberOfAttemps);
            if (number < 1)
                throw new IllegalArgumentException(UNDER_NUMBER_ERROR);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }
}
