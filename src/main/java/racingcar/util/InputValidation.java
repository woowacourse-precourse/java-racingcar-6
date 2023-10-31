package racingcar.util;

public class InputValidation {
    public static final String CAR_LENGTH_ERROR_MSG = "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.";
    public static final String USER_INPUT_NUMBER_ERROR_MSG = "[ERROR] 이동 횟수는 1이상의 자연수이어야 합니다.";

    public static void validateCarNameLength(String carName) {
        if (1 <= carName.length() && carName.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException(CAR_LENGTH_ERROR_MSG);
    }

    public static void validateUserInputNumberFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(USER_INPUT_NUMBER_ERROR_MSG);
        }
    }

    public static void validateUserInputNumberRange(String userInput) {
        if (0 < Integer.parseInt(userInput)) {
            return;
        }
        throw new IllegalArgumentException(USER_INPUT_NUMBER_ERROR_MSG);
    }
}
