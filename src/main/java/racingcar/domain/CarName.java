package racingcar.domain;

public class CarName {

    private final String name;

    private CarName(final String name) {
        validate(name);
        this.name = name;
    }

    public static CarName from(final String name) {
        return new CarName(name);
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 빈 문자열입니다.");
        }
    }
}
