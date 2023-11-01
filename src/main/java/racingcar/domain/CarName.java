package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.exception.RacingCarException;

public class CarName {
    private final String name;

    public CarName(final String name) {
        validateLength(name);
        validateEmpty(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateEmpty(String name) {
        if (isEmptyValue(name)) {
            throw new RacingCarException(ErrorMessage.EMPTY_VALUE);
        }
    }

    private void validateLength(String name) {
        if (isOverLength(name)) {
            throw new RacingCarException(ErrorMessage.OUT_OF_STANDARD);
        }
    }

    private boolean isEmptyValue(String name) {
        return name.trim().isBlank();
    }

    private boolean isOverLength(String name) {
        return 5 < name.length();
    }
}
