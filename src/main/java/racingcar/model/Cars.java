package racingcar.model;

import java.util.Comparator;
import java.util.List;
import racingcar.dto.CarsState;
import racingcar.validator.CarsValidator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String inputCars) {
        cars = toCars(CarsValidator.INSTANCE.validate(inputCars));
    }

    private List<Car> toCars(List<String> names) {
        return names.stream()
                .map(Name::new)
                .map(this::createCar)
                .toList();
    }

    private Car createCar(Name name) {
        return new Car(name, createPosition());
    }

    private Position createPosition() {
        return new Position();
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