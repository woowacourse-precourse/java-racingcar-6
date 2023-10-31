package racingcar.domain;

public class CarName {
    private static final int MAXIMUM_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isGreaterThanMaximumLength(name)) {
            throw new IllegalArgumentException("이름은 5자이내여야 합니다.");
        }
    }

    private boolean isGreaterThanMaximumLength(String name) {
        return name.length() > MAXIMUM_LENGTH;
    }

    public String getName() {
        return name;
    }
}
