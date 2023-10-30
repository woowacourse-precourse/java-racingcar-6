package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.Validator;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> racingCarNames) {
        Validator.validateIsDuplicate(racingCarNames);

        cars = new ArrayList<>();
        for (String name : racingCarNames) {
            cars.add(new Car(name, new RandomNumberGenerator()));
        }
    }

    public List<String> findWinner() {
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .orElse(cars.get(0));

        return cars.stream()
                .filter(car -> car.isWinner(maxDistanceCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }


    public void tryToMoveCars() {
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