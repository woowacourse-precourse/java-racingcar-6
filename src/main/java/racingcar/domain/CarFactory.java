package racingcar.domain;

import java.util.List;
import racingcar.vo.CarName;

public class CarFactory {


    public RacingCars createCarsWithNames(List<CarName> names) {
        List<Car> cars = names.stream()
                              .map(this::createCarWithName)
                              .toList();
        return new RacingCars(cars);
    }

    public Car createCarWithName(CarName name) {
        return new Car(name);
    }

}
