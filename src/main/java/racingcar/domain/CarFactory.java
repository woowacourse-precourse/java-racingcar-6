package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.validator.Validator;

public class CarFactory {
    public static List<Car> produceCars(List<String> carNameList) {
        Validator.carName(carNameList);

        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
