package racingcar.firstclasscollection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

public class CarList {
    List<Car> cars;

    public CarList() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
        cars.add(car);
    }

    public void forEachCar(Consumer<Car> consumer) {
        for (Car car : cars) {
            consumer.accept(car);
        }
    }
}
