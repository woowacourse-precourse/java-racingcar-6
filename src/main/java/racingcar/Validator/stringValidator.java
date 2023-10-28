package racingcar.Validator;

public class stringValidator {
    private final static int INPUT_VALUE_MAX_LENGTH = 5;
    private final static String INVALID_INPUT_LENGTH_MESSAGE = "입력 길이는 5자 이하입니다."

    public static void validateCarNameLength(String input){
        if(input.length() > INPUT_VALUE_MAX_LENGTH){
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
        }
    }
}
