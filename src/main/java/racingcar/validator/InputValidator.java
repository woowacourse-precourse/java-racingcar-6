package racingcar.validator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

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

    private void includeNumberOrSymbol() {
        if (!Pattern.matches("^[a-z|A-Z|,]*$", input)) {
            throw new IllegalArgumentException("쉼표 외 특수 기호 혹은 숫자가 포함되어 있습니다.");
        }
    }
}
