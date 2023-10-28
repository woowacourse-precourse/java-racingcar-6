package racingcar;

import java.util.List;

import racingcar.Model.Car;

public class Validator {

    public void validateCarsNames(List<Car> cars) {
        validateCarsNamesDuplicate(cars);
        validateCarsNamesLength(cars);
    }

    private void validateCarsNamesDuplicate(List<Car> cars) {
        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = i + 1; j < cars.size(); j++) {
                validateEqualCarName(cars.get(i).getName(), cars.get(j).getName());
            }
        }
    }

    private void validateEqualCarName(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarsNamesLength(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            validateNameLength(cars.get(i).getName());
            validateEmptyName(cars.get(i).getName());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEmptyName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
