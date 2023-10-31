package racingcar.domain;

public class CarName {
    private static final int MAXIMUM_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if (isGreaterThanMaximumLength()) {
            throw new IllegalArgumentException("이름은 5자이내여야 합니다.");
        }
    }

    private boolean isGreaterThanMaximumLength() {
        return name.length() > MAXIMUM_LENGTH;
    }

    public String getName() {
        return name;
    }
}
