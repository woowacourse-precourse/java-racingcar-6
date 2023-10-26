package racingcar.Util;

public class Validator {

    public static final String NULL_OR_EMPTY_MESSAGE = "값을 입력해주세요";

    public static void validateCarNames(String inputedCarNames) {
        validateNullOrEmpty(inputedCarNames);
    }

    public static void validateNullOrEmpty(String inputedCarNames) {
        if (inputedCarNames == null || inputedCarNames.equals("")){
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }
}
