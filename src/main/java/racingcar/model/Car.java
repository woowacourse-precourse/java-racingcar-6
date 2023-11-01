package racingcar.model;

import racingcar.validator.CarValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final CarValidator carValidator;
    private List<String> carList = new ArrayList<>();

    public Car(CarValidator carValidator) {
        this.carValidator = carValidator;
    }

    public List<String> extractCarList(String cars) {
        carList = Arrays.asList(cars.split(","));
        carValidator.validateCarCount(carList);
        carValidator.validateCarNameLength(carList);
        carValidator.validateCarNameDuplication(carList);
        return carList;
    }
}
