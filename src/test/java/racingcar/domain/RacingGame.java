package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(String carNames) {
        List<String> members = Arrays.asList(carNames.split(","));
        this.cars = members.stream()
                .map(member -> new Car(member, 0))
                .toList();
    }

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
