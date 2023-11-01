package racingcar.domain;

import racingcar.validation.InputFormatValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        InputFormatValidator.validateDuplicateCarName(cars, car);
        cars.add(car);
    }

    public void moveCars(RandomNumbers randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            get(i).move(randomNumbers.get(i));
        }
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public List<Car> getCars() {
        return cars;
    }

}
