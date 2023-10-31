package racingcar.model;

import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(){
        cars = new ArrayList<>();
    }

    public void setNames(String alignedCarNames) {
        InputValidator.validateConsecutiveCommas(alignedCarNames);
        String[] carNames = alignedCarNames.split(",");
        InputValidator.validateName(carNames);
        InputValidator.validateNameLength(carNames);
        InputValidator.validateName(carNames);

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

    }
}
