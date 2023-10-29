package racingcar.validator;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
    private String input;

    public InputValidator(String input) {
        this.input = input;
        isNullOrIsEmpty();
    }

    private void isNullOrIsEmpty() {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무 것도 입력하지 않았습니다.");
        }
    }
}
