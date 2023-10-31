package racingcar.model;

import java.util.List;
import racingcar.dto.RoundResult;
import racingcar.util.CarsGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(String inputCarNames) {
        cars = CarsGenerator.INSTANCE.generate(inputCarNames);
    }

    public void attemptForward() {
        cars.forEach(Car::attemptForward);
    }

    public RoundResult getRoundResult() {
        return new RoundResult(cars.stream()
                .map(Car::getCarResult)
                .toList());
    }

    public List<Car> findWinningCars() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(cars -> cars.getPosition() == maxPosition)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }
}