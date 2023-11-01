package racingcar.domain;

import java.util.List;

public class CarManager {

    private final List<Car> cars;
    private int maxCount;

    private CarManager(List<Car> cars) {
        this.cars = cars;
        this.maxCount = 0;
    }

    public static CarManager createFromInputCarNames(String inputCarNames) {
        List<String> carNames = NameSeparator.separateNamesByComma(inputCarNames);
        List<Car> cars = carNames.stream().map(Car::createFromName).toList();
        return new CarManager(cars);
    }

    public void orderCarsMoveForward() {

    }

}
