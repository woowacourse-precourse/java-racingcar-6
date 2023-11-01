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
        if (isInvalidCarNameLength(carName)) {
            throw new IllegalArgumentException(NOT_AVAILABLE_CAR_NAME_LENGTH_RANGE.getMessage());
        }
    }

    private static boolean isInvalidCarNameLength(String carName) {
        return carName.isEmpty() || carName.isBlank() || MAX_CAR_NAME_LENGTH < carName.length();
    }

    private void validateCharacter(String carName) {
        if (isInvalidCarNameCharacter(carName)) {
            throw new IllegalArgumentException(NOT_AVAILABLE_CAR_NAME_CHARACTER.getMessage());
        }
    }

    private static boolean isInvalidCarNameCharacter(String carName) {
        return !carName.matches(AVAILABLE_CHARACTER_REGEX);
    }

    public String getName() {
        return this.name;
    }
}
