package racingcar.domain.car;

import org.junit.platform.commons.util.StringUtils;

public record Name(String name) {

    private static final int MAX_LENGTH = 5;
    private static final String OVER_LENGTH_MESSAGE = "이름이 제한 길이를 초과하였습니다.";
    private static final String BLANK_MESSAGE = "빈 문자열은 이름이 될 수 없습니다.";

    public Name {
        validateInputName(name);
    }

    private void validateInputName(final String name) {
        validateBlank(name);
        validateOverLength(name);
    }

    private void validateOverLength(final String name) {
        if (isOverLength(name)) {
            throw new IllegalArgumentException(OVER_LENGTH_MESSAGE);
        }
    }

    private void validateBlank(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private boolean isOverLength(final String name) {
        return name.length() > MAX_LENGTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
