package racingcar.domain.car;

import java.util.List;
import racingcar.domain.exception.CarNameContainsBannedCharacterException;
import racingcar.domain.exception.InvalidCarNameLengthException;

public record CarName(String carName) {

    public static final List<String> BANNED_CHARACTERS = List.of(" ", "\n", "\r", "\t");
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public CarName {
        validateCarNameLength(carName);
        validateNotContainsBannedChars(carName);
    }

    private static void validateCarNameLength(final String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new InvalidCarNameLengthException();
        }
    }

    private static void validateNotContainsBannedChars(final String carName) {
        if (containsBannedChars(carName)) {
            throw new CarNameContainsBannedCharacterException();
        }
    }

    private static boolean containsBannedChars(final String carName) {
        return BANNED_CHARACTERS.stream()
                .anyMatch(carName::contains);
    }
}
