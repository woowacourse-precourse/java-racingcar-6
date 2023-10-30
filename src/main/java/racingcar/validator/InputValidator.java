package racingcar.validator;

import static racingcar.model.Constants.MAX_NAME_LENGTH;

public class InputValidator {
    public static void checkRepetitionIsNumber(String userRepeat) throws IllegalArgumentException {
        if(!userRepeat.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static void checkRepetitionIsPositive(String userRepeat) throws IllegalArgumentException {
        if(Integer.parseInt(userRepeat) < 0) {
            throw new IllegalArgumentException("양수만 입력해주세요.");
        }
    }

    public static void checkNameLengthIsOverflow(String carName, Integer maxLength) throws IllegalArgumentException {
        if (carName.isEmpty() || carName.length() > maxLength) {
            throw new IllegalArgumentException("5자 이하의 이름만 입력하세요.");
        }
    }

}
