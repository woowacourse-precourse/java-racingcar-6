package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public List<String> findWinner() {
        int winnersPosition = findWinnersPosition();
        return cars.stream()
                .filter(car -> car.isWinner(winnersPosition))
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    public int findWinnersPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void roundLevelMove() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.createRandomNumber());
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.cars);
    }
}
