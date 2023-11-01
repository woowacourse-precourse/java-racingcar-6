package racingcar.domain;

import java.util.List;
import racingcar.vo.CarName;

public class CarFactory {


    public RacingCars createCarsWith(List<CarName> names) {
        List<Car> cars = names.stream()
                              .map(this::createCarWith)
                              .toList();
        return new RacingCars(cars);
    }

    public Car createCarWith(CarName name) {
        return new Car(name);
    }

}
