package racingcar.validator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputValidator {
    public static void isNullOrIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무 것도 입력하지 않았습니다.");
        }
    }

    public static void includeNumberOrSymbol(String input) {
        if (!Pattern.matches("^[a-z|A-Z|,]*$", input)) {
            throw new IllegalArgumentException("쉼표 외 특수 기호 혹은 숫자가 포함되어 있습니다.");
        }
    }
}
