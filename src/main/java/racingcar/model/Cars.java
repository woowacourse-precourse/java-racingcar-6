package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.NumberGenerator;

public class Cars {

    private static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFromCarNames(final List<String> carsName) {
        List<Car> cars = new ArrayList<>();
        for (final String carName : carsName) {
            cars.add(new Car(new Name(carName), new Position(DEFAULT_POSITION)));
        }
        return new Cars(cars);
    }

    public void moveAll(final NumberGenerator generator) {
        cars.forEach(car -> car.move(generator));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
