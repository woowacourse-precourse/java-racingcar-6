package racingcar.dto.input;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.validator.InputValidator.validateRacingCars;

public record RacingCarsDto(String carName) {
    public RacingCarsDto {
        validateRacingCars(carName);
    }

    public RacingCars toRacingCars() {
        String[] splitStrings = carName.split(",");
        final List<RacingCar> racingCars = Arrays.stream(splitStrings)
                .map(RacingCar::new)
                .collect(Collectors.toList());
        return RacingCars.from(racingCars);
    }

}
