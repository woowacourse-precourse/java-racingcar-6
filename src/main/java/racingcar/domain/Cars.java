package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        carList = carNames.stream().map(Car::new).toList();
    }

    public void run(NumberGenerator numberGenerator) {
        for (Car car : carList) {
            int randomNumber = numberGenerator.generator();
            car.run(randomNumber);
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public List<String> findWinners() {
        int maxDistance = carList.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(NoSuchElementException::new)
                .getDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }
}
