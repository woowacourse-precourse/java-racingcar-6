package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.create(carName));
        }
        return new Cars(cars);
    }

    public void play() {
        cars.forEach(Car::play);
    }

    public List<Integer> provideRoundResult() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    public List<Car> determineWinners() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
