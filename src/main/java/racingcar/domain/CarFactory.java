package racingcar.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.validator.Validator;

public class CarFactory {
    public static Cars produceCars(List<String> carNameList) {
        Validator.carName(carNameList);

        return carNameList.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
