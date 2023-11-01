package racingcar.car;

import racingcar.util.RandomUniqueNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCars(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomUniqueNumber = RandomUniqueNumber.pickRandomUniqueNumber();
            car.canMove(randomUniqueNumber);
        }
    }

    public List<String> getGameWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getDistance() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getDistance)
                .mapToInt(distance -> distance)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
