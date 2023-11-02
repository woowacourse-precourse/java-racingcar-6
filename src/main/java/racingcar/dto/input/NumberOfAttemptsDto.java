package racingcar.dto.input;

import static racingcar.validator.InputValidator.validateNumberOfAttempts;

public record NumberOfAttemptsDto(String attempt) {
    public NumberOfAttemptsDto {
        validateNumberOfAttempts(attempt);
    }

    public Integer toInteger() {
        return Integer.parseInt(attempt);
    }
}
