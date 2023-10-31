package racingcar.domain;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public class CarNameValidator implements Consumer<String> {
    private static final String NOT_BLANK_NAME = "자동차 이름은 비어있을 수 없습니다";
    private static final String NO_WHITESPACE_AROUND_NAME = "자동차 이름 양 옆에 공백이 올 수 없습니다";
    private static final Pattern WHITE_SPACE_AROUND_STRING = Pattern.compile("^\\s+|\\s+$");
    private static final String INVALID_NAME_LENGTH_FORMAT = "자동차 이름은 %d자 이하여야 합니다";
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void accept(String name) {
        validateBlank(name);
        validateWhiteSpaceAround(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK_NAME);
        }
    }

    private void validateWhiteSpaceAround(String name) {
        if (WHITE_SPACE_AROUND_STRING.matcher(name).find()) {
            throw new IllegalArgumentException(NO_WHITESPACE_AROUND_NAME);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_FORMAT, MAX_NAME_LENGTH));
        }
    }
}
