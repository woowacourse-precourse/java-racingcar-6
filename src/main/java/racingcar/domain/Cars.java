package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.constant.Constant;
import racingcar.utils.validation.InputValidation;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        List<String> carList = splitCarNames(carNames);
        InputValidation.validateNameDuplicated(carList);
        this.cars = createCars(carList);

    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(Constant.SPLIT_DELIMITER));
    }

    private List<Car> createCars(List<String> carList) {
        return carList.stream()
            .map(car -> new Car(car))
            .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public int getMaxCount() {
        return cars.stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElse(Constant.MIN_RANDOM_NUMBER);
    }

    public List<String> getWinnerNames() {
        int maxCount = getMaxCount();
        return cars.stream()
            .filter(car -> car.getMoveCount() == maxCount)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
