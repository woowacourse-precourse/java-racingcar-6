package racingcar.validator;

import java.util.List;

public record CarNameValidator(List<String> carNames) {

    public CarNameValidator {
        validateCarName(carNames);
    }

    public void validateCarName(
            List<String> carNames
    ) {
        if (isOverFiveLetters(carNames) || isInputBlankCarName(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInputBlankCarName(
            List<String> carNames
    ) {
        return carNames.stream()
                .anyMatch(String::isBlank);
    }

    private boolean isOverFiveLetters(
            List<String> carNames
    ) {
        return carNames.stream()
                .anyMatch(name -> name.length() > 5);
    }
}
