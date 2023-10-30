package racingcar.model;

import java.util.List;

public interface Model {
    static Car generateCar(String name, int index) {
        return new Car(name, index);
    }
    static Rank generateRank(final List<Car> cars) {
        return new Rank(cars);
    }
}
