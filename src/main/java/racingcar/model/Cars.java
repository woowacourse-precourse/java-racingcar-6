package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.Validator;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        Validator.validateIsDuplicate(getCarNames(cars));

        this.cars = cars;
    }

    private List<String> getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> findWinners() {
        Car maxDistanceCar = findMaxDistanceCar();

        return cars.stream()
                .filter(car -> car.isWinner(maxDistanceCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElse(cars.get(0));
    }


    public void moveCars() {
        for (Car car : cars) {
            car.moveOrStay();
        }
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }
}