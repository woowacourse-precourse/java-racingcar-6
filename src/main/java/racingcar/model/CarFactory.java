package racingcar.model;

import racingcar.util.ProductionRandomNumberUtil;
import racingcar.util.RandomNumberUtil;

import java.util.List;

public class CarFactory {

    private static final int INITIAL_CAR_POSITION = 0;
    private static final RandomNumberUtil randomNumberUtil = new ProductionRandomNumberUtil();

    public static List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(randomNumberUtil, carName, INITIAL_CAR_POSITION))
                .toList();
    }
}
