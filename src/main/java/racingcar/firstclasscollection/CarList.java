package racingcar.firstclasscollection;

import java.util.List;
import java.util.function.Consumer;
import racingcar.model.Car;

public class CarList {
    List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void forEachCar(Consumer<Car> consumer) {
        for (Car car : cars) {
            consumer.accept(car);
        }
    }
}
