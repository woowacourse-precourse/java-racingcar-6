package racingcar.Validator;

public class NumberValidator {

    private final static String INVALID_TYPE_MESSAGE = "숫자로 이루어진 값을 입력해주세요";
    private final static String INVALID_RANGE_NUMBER_MESSAGE = "0보다 작은 값을 입력해주세요";

    private final static int MIN_INPUT_VALUE = 0;
    public static void validateIsNumberic(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE_MESSAGE);
        }
    }

    public static void validateIsInRange(String input){
        if(Integer.parseInt(input) <= MIN_INPUT_VALUE)
        {
            throw new IllegalArgumentException(INVALID_RANGE_NUMBER_MESSAGE);
        }
    }
}
