package racingcar.domain.car;

import java.util.List;

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
            throw new IllegalArgumentException("차 이름은 1~5자여야 합니다.");
        }
    }

    private static void validateNotContainsBannedChars(final String carName) {
        if (containsBannedChars(carName)) {
            throw new IllegalArgumentException("차 이름은 공백이 포함될 수 없습니다.");
        }
    }

    private static boolean containsBannedChars(final String carName) {
        return BANNED_CHARACTERS.stream()
                .anyMatch(carName::contains);
    }
}
