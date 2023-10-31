package racingcar.model;

import java.util.List;

public interface Model {
    static Model generateCar(final String name, final int index) {
        return new Car(name, index);
    }

    static Model generateRank(final List<Car> cars) {
        return new CarRank(cars);
    }
}
