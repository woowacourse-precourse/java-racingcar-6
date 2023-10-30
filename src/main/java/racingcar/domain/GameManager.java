package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    public List<Car> createCar(String[] carNames) {

        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }
}
