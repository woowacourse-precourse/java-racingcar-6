package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.NumberGenerator;

public class Cars {
    private List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void tryMoveCars() {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.generateRandomNumber();

            car.moveForward(randomNumber);
            car.showMoveDistance();
        }
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findFarthestPositionCar();
        List<Car> winners = findSamePositionCar(maxPositionCar);

        return Collections.unmodifiableList(winners);
    }

    public Car findFarthestPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어있습니다."));
    }

    public List<Car> findSamePositionCar(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.compareTo(maxPositionCar) == 0)
                .collect(Collectors.toList());
    }
}
