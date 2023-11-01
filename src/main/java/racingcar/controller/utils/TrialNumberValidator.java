package racingcar.controller.utils;

public class TrialNumberValidator {
    public void validateTrialNumberInput(String input) throws IllegalArgumentException {
        checkIsEmpty(input);
        checkIsNumber(input);
    }

    public void checkIsEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력하세요");
        }
    }

    public void checkIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
