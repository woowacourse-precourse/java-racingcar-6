package racingcar;

import java.util.Comparator;
import java.util.List;
import racingcar.validator.CarsValidator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String inputCars) {
        CarsValidator validator = CarsValidator.INSTANCE;
        List<String> names = validator.validate(inputCars);

        cars = toCars(names);
    }

    private List<Car> toCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(new Name(name), new Position()))
                .toList();
    }


    public void attemptForward() {
        for (Car car : cars) {
            car.attemptForward();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWiiningCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream().toList();
    }
}
