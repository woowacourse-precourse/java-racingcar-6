package racingcar.model;

import java.util.Comparator;
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
                .map(Car::getCarState)
                .toList());
    }

    public List<Car> findWinningCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream().toList();
    }
}