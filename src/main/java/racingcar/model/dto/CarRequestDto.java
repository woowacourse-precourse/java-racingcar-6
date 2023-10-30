package racingcar.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;
import racingcar.utils.Parser;
import racingcar.utils.Validator;

public class CarRequestDto {
    private final List<String> carNames;

    public CarRequestDto(String inputCarNames) {
        Validator.validateAndParseCarNames(inputCarNames);
        carNames = Parser.parseCarNames(inputCarNames);
    }

    public List<Car> toCar() {
        return carNames.stream().map(Car::from).collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
