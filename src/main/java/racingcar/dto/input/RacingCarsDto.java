package racingcar.dto.input;

import static racingcar.validator.InputValidator.validateRacingCars;

public record RacingCarsDto(String carName) {
    public RacingCarsDto {
        validateRacingCars(carName);
    }
}
