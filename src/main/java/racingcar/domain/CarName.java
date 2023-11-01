package racingcar.domain;

import static racingcar.exception.RacingCarExceptionMessage.NOT_AVAILABLE_CAR_NAME_CHARACTER;
import static racingcar.exception.RacingCarExceptionMessage.NOT_AVAILABLE_CAR_NAME_LENGTH_RANGE;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String AVAILABLE_CHARACTER_REGEX = "[a-zA-Z0-9가-힣]*";
    private final String name;

    public CarName(String name) {
        validateLength(name);
        validateCharacter(name);
        this.name = name;
    }

    private void validateLength(String carName) {
        if (carName.isEmpty() || carName.isBlank() || MAX_CAR_NAME_LENGTH < carName.length()) {
            throw new IllegalArgumentException(NOT_AVAILABLE_CAR_NAME_LENGTH_RANGE.getMessage());
        }
    }

    private void validateCharacter(String carName) {
        if (!carName.matches(AVAILABLE_CHARACTER_REGEX)) {
            throw new IllegalArgumentException(NOT_AVAILABLE_CAR_NAME_CHARACTER.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }
}
