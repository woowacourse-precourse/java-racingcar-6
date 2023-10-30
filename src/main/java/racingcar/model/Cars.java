package racingcar.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(List<String> CarNameList) {
        return CarNameList.stream()
                .map(Car::create)
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
