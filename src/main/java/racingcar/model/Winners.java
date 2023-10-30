package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Winners from(List<Car> winners) {
        return new Winners(winners);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
