package racingcar.domain;

import java.util.List;
import racingcar.domain.strategy.CarMovementStrategy;

public class CarsGenerator {

    private final CarMovementStrategy carMovementStrategy;

    public CarsGenerator(CarMovementStrategy carMovementStrategy) {
        this.carMovementStrategy = carMovementStrategy;
    }

    public Cars generateCarsFromNames(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> new Car(name, carMovementStrategy))
                .toList();

        return new Cars(cars);
    }

}
