package racingcar.Validator;

public class TurnNumInputValidator {
    private static final String ASK_INT_UNDER_PROPER_AMOUNT = "잘못된 입력입니다. 적정한 수를 정수 형태로 입력해주세요";
    private static final String ASK_POSITIVE_NUM_INPUT = "잘못된 입력입니다. 0이상의 수를 입력해주세요";
    private static final int MIN_TURN_NUM = 1;


    public void validate(String turnNumInputString) {
        isInputDigit(turnNumInputString);
        isPositive(turnNumInputString);
    }

    public void isInputDigit(String turnNumInputString) {
        try {
            Integer.parseInt(turnNumInputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ASK_INT_UNDER_PROPER_AMOUNT);
        }
    }

    public void isPositive(String turnNumInputString) {
        Integer turnNumInputInteger = Integer.parseInt(turnNumInputString);
        if (turnNumInputInteger < MIN_TURN_NUM) {
            throw new IllegalArgumentException(ASK_POSITIVE_NUM_INPUT);
        }
    }

}
