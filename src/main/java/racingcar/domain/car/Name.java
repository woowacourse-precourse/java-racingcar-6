package racingcar.domain.car;

import org.junit.platform.commons.util.StringUtils;

public record Name(String name) {

    private static final int MAX_LENGTH = 5;

    public Name {
        validateInputName(name);
    }

    private void validateInputName(final String name) {
        validateBlank(name);
        validateOverLength(name);
    }

    private void validateOverLength(final String name) {
        if (isOverLength(name)) {
            throw new IllegalArgumentException("이름이 제한 길이를 초과하였습니다.");
        }
    }

    private void validateBlank(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("빈 문자열은 이름이 될 수 없습니다.");
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
