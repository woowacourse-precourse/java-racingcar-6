package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Validator;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    public Cars(String[] carNames) {
        for(String carName : carNames) {
            Validator.validateName(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private int findMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<Car> getWinnerCars() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
