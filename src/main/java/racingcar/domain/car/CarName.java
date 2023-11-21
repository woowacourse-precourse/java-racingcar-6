package racingcar.domain.car;

import racingcar.exception.RacingException;

public class CarName {
    public static final int NAME_MAX_LEN = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > NAME_MAX_LEN) {
            throw RacingException.INVALID_CARS_NAME.makeException();
        }
    }

    public String getName() {
        return name;
    }
}
