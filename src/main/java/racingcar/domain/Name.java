package racingcar.domain;

import racingcar.util.RacingCarGameUtil;

public class Name {

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Name from(Object value) {
        if (!RacingCarGameUtil.validNameType(value)) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }
        if (RacingCarGameUtil.validNameLength((String) value)) {
            return new Name((String) value);
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }
}
