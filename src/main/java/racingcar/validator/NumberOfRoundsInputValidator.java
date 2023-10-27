package racingcar.validator;

public class NumberOfRoundsInputValidator implements BasicValidator {

    @Override
    public void validate(String userInput) {
        isInputEmpty(userInput);
        isInputInteger(userInput);
        isInputPositive(userInput);
        isInputNumeric(userInput);
    }

    private void isInputEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void isInputNumeric(String userInput) {
        if (!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private void isInputPositive(String userInput) {
        if (Integer.parseInt(userInput) <= 0) {
            throw new IllegalArgumentException("입력값이 0 이하의 숫자입니다.");
        }
    }

    private void isInputInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }
}
