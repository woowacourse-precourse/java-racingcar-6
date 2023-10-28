package racingcar.model;

import java.util.List;

public class CarFactory {

    private static final CarFactory instance = new CarFactory();

    private static Long id = 0L;

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return instance;
    }

    public List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(++id, carName))
                .toList();
    }
}
