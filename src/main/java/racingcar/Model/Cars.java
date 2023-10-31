package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

import racingcar.Validator;

public class Cars {

    private List<Car> cars;
    private Validator validator = new Validator();

    public Cars(List<Car> cars) {
        validator.validateCarsNames(cars);
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return this.cars;
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public List<Integer> getCarpositions() {
        List<Integer> carPositions = new ArrayList<>();
        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }
        return carPositions;
    }
}
