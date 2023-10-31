package racingcar.validation;

import java.util.List;

public class Validation {
    private static final int MAX_NAME_LENGTH = 5;

    public static void inputCarNameValidate(List<String> carNames) {
        if (carNames.stream()
                .filter(carName -> !carName.isEmpty() && carName.length() <= MAX_NAME_LENGTH)
                .count() != carNames.size()
        ) {
            throw new IllegalArgumentException();
        }

    }

    public static void inputRacingTimeValidate(String racingTime){
        if(!racingTime.matches("^[1-9]$")) {
            throw new IllegalArgumentException();
        }
    }

}
