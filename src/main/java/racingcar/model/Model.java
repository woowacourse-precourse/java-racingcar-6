package racingcar.model;

import java.util.List;

public interface Model {
    static Car generateCar(String name) {
        return new Car(name);
    }
    static Rank generateRank(final List<Car> cars) {
        return new Rank(cars);
    }
}
