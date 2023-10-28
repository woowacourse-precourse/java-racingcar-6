package racingcar.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars;

    public void makeCars(List<String> carNames) {
        cars.addAll(carNames.stream()
                .map(Car::makeCar)
                .collect(toList()));
    }

}
