package racingcar.Validator;

public class TurnNumInputValidator {
    private int turnNumInputInt;
    private final String ASK_NUMBER_INPUT = "잘못된 입력입니다. 숫자만 입력해야 합니다";
    private final String ASK_POSITIVE_NUM_INPUT = "잘못된 입력입니다. 0이상의 수를 입력해주세요";
    private final int MIN_TURN_NUM = 1;
    

    public void validate(String turnNumInputString) {
        isInputDigit(turnNumInputString);
        isPositive();
    }

    public void isInputDigit(String turnNumInputString) {
        try {
            this.turnNumInputInt = Integer.parseInt(turnNumInputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ASK_NUMBER_INPUT);
        }
    }

    public void isPositive() {
        if (turnNumInputInt < MIN_TURN_NUM) {
            throw new IllegalArgumentException(ASK_POSITIVE_NUM_INPUT);
        }
    }

}
