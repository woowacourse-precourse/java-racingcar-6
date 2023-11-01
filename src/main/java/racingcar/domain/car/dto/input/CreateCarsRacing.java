package racingcar.domain.car.dto.input;

import java.util.List;
import racingcar.domain.car.validator.CarsValidator;

public record CreateCarsRacing(List<String> carNames) {

    public CreateCarsRacing {
        CarsValidator.validateCarsCount(carNames);
        CarsValidator.validateDuplicateCarNames(carNames);
    }
}
