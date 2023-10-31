package racingcar.firstclasscollection;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

public class CarList {
    List<Car> cars;

    public CarList(Supplier<List> listSupplier) {
        this.cars = listSupplier.get();
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
