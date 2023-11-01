package racingcar.model;

import static racingcar.util.Constants.MAX_NUMBER;
import static racingcar.util.Constants.MIN_NUMBER;
import static racingcar.util.Constants.ONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Constants;
import racingcar.util.validate.CarsValidateImpl;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNamesStr) {
        String[] carNames = carNamesStr.split(Constants.COMA);
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

    public void moveAll() {
        cars.forEach(car -> car.go(RandomGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER + ONE)));
    }

    public Winner getWinners() {
        return new Winner(cars);
    }

}


