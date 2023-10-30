package racingcar.model;

import java.util.Comparator;
import java.util.List;
import racingcar.dto.CarsState;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String inputCars) {
        CarsGenerator carsGenerator = new CarsGenerator();
        cars = carsGenerator.generate(inputCars);
    }

    public void attemptForward() {
        cars.forEach(Car::attemptForward);
    }

    public CarsState getCarsState() {
        return new CarsState(cars.stream()
                .map(Car::getCarState)
                .toList());
    }

    public List<Car> findWinningCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream().toList();
    }
}