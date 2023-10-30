package racingcar.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;
import racingcar.utils.Parser;
import racingcar.utils.Validator;

public class CarRequestDto {
    private final List<String> carNames;

    public CarRequestDto(String inputCarNames) {
        carNames = parseAndValidate(inputCarNames);
    }

    public List<Car> toCar() {
        return carNames.stream().map(Car::from).collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private List<String> parseAndValidate(String inputCarNames) {
        Validator.validateCarNames(inputCarNames);
        return Parser.parseCarNames(inputCarNames);
    }
}