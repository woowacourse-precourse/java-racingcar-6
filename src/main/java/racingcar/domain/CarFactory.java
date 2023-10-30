package racingcar.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class CarFactory {
    public Cars produceCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
