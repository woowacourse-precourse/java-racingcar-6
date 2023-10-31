package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE_NAME_LENGTH = "자동차 이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.";

    private final String name;
    private int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
