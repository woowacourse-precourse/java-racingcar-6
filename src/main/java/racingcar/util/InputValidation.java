package racingcar.util;

public class InputValidation {

    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String INTEGER_REGEX = "^[0-9]*$";
    public static final String CAR_NAME_ERROR_MSG = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    public static final String Count_ERRO_MSG = "이동 횟수는 1이상의 자연수이어야 합니다.";

    public static boolean validateCarNameLength(String carName) {
        if (1 <= carName.length() && carName.length() <= 5) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_SYMBOL + CAR_NAME_ERROR_MSG);
    }

    public static boolean validateCount(String userInput) {
        if (userInput.matches(INTEGER_REGEX)) {
            return true;
        }

        throw new IllegalArgumentException(ERROR_SYMBOL + Count_ERRO_MSG);


    }
}
