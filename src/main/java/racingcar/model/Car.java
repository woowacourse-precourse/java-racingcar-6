package racingcar.model;

import java.util.Objects;
import racingcar.model.dto.CarDTO;
import racingcar.utils.Validation;

public class Car extends CarDTO implements Comparable<Car> {

    public Car(String name) {
        super(name);
        Validation.validateName(name);
    }

    public Car(String name, int dist) {
        super(name, dist);
    }

    private int getDist() {
        return dist;
    }

    public void moveForward() {
        dist++;
    }

    public CarDTO toCarDTO() {
        return new CarDTO(name, dist);
    }

    @Override
    public int compareTo(Car other) {
        Objects.requireNonNull(other);
        return Integer.compare(getDist(), other.getDist());
    }
}
