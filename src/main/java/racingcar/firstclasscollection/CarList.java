package racingcar.firstclasscollection;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

public class CarList {
    private final List<Car> cars;

    public CarList(Supplier<List<Car>> listSupplier) {
        this.cars = listSupplier.get();
    }

    /**
     * add Car instance in CarList
     *
     * @param car
     * @throws IllegalArgumentException when add duplicated cars
     */
    public void addCar(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
        cars.add(car);
    }

    /**
     * consume each car in CarList
     *
     * @param consumer behavior to consume car
     */
    public void forEachCar(Consumer<Car> consumer) {
        for (Car car : cars) {
            consumer.accept(car);
        }
    }
}
