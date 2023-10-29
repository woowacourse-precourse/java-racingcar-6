package racingcar.domain;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.vo.CarName;

public class CarFactory {


    public Cars createCarsWithNames(List<CarName> names) {
        List<Car> cars = names.stream()
                               .map(this::createCarWithName)
                               .toList();
        return new Cars(cars);
    }

    public Car createCarWithName(CarName name) {
        return new Car(name);
    }

}
