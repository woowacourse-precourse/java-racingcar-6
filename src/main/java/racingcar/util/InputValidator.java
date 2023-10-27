package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputValidator {
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,\\\\s?[a-zA-Z]{1,5})*";

    public void validatePlayerNamesFormat(String input) {
        Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }
    }

    public void validateNonEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력했습니다.");
        }
    }
    
    public void validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 문자열만 입력할 수 있습니다.");
        }
    }
}
