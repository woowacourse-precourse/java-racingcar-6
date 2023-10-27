package racingcar.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarPark;
import racingcar.service.InputConvertService;
import racingcar.service.ValidateService;
import racingcar.vo.Car;

public class InputConvertServiceImpl implements InputConvertService {

    private final ValidateService validateService;

    public InputConvertServiceImpl(ValidateService validateService) {
        this.validateService = validateService;
    }

    @Override
    public CarPark inputConvertCarPark(String input) {
        validateService.validateInputLastCharEqualCommas(input);
        List<String> carNames = Arrays.asList(input.split(","));
        List<Car> carList = carNames.stream()
                .peek(validateService::validateNamesSizeLessThanFive)
                .map(carName -> new Car(carName, 0))
                .collect(Collectors.toList());
        return new CarPark(carList);
    }
}
