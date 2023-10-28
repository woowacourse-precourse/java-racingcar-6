package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.constant.Constant;
import racingcar.utils.validation.InputValidation;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        List<String> carList = splitCarNames(carNames);
        InputValidation.validateNameDuplicated(carList);
        this.cars = createCar(carList);

    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(Constant.SPLIT_DELIMITER));
    }

    private List<Car> createCar(List<String> carList) {
        return carList.stream()
            .map(car -> new Car(car))
            .collect(Collectors.toList());
    }
}
