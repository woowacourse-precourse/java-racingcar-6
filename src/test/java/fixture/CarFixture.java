package fixture;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarName;

public class CarFixture {

    public static Car createCar(final String name) {
        return Car.createWith(new CarName(name));
    }

    public static List<Car> createCars(final List<String> names) {
        return names.stream()
                .map(name -> Car.createWith(new CarName(name)))
                .toList();
    }
}
