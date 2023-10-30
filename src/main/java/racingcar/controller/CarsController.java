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
        List<String> carNames =  Arrays.asList(inputName.split(SEPARATOR));
        checkCarNamesIsEmpty(carNames);
        return carNames;
    }

    private void checkCarNamesIsEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}
