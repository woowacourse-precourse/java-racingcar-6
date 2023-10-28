package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.util.validate.CarsValidateImpl;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNamesStr) {
        String[] carNames = carNamesStr.split(",");
        CarsValidateImpl.createValue(carNames);
        addCarsToList(carNames);
    }

    private void addCarsToList(String[] carNames) {
        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(cars::add);
    }
    public List<Car> getCars() {
        return cars;
    }
}


