package racingcar.model;

import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public final List<Car> cars;

    public CarManager(){
        cars = new ArrayList<>();
    }

    public void setNames(String alignedCarNames) {
        InputValidator.validateConsecutiveCommas(alignedCarNames);
        String[] carNames = alignedCarNames.split(",");
        InputValidator.validateName(carNames);
        InputValidator.validateNameLength(carNames);
        InputValidator.validateDuplicateName(carNames);

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

    }
}
