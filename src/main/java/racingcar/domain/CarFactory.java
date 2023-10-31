package racingcar.domain;

import java.util.List;
import racingcar.strategy.MoveStrategy;

public class CarFactory {
    private CarFactory() {
    }

    public static Cars createCarsFromNamesWithStrategy(List<String> carNames, MoveStrategy moveStrategy) {
        List<Car> cars = carNames.stream()
                .map(Name::from)
                .map(name -> Car.of(name, moveStrategy))
                .toList();

        return Cars.from(cars);
    }
}