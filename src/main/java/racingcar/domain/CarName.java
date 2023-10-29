package racingcar.domain;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private static final String ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
