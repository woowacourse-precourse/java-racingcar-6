package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsController implements CarsCreator {
    private static final String SEPARATOR = ",";

    @Override
    public Cars createCars(String inputName) {
        List<String> carNames = splitInputNames(inputName);
        return new Cars(createCarList(carNames));
    }

    private List<Car> createCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<String> splitInputNames(String inputName) {
        return Arrays.asList(inputName.split(SEPARATOR));
    }
}
