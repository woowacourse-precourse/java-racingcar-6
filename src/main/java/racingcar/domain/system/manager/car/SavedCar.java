package racingcar.domain.system.manager.car;

import java.util.Objects;
import racingcar.domain.core.car.Car;

public class SavedCar {

    private final Car car;
    private final CarKey key;

    public SavedCar(Car car, CarKey key) {
        this.car = car;
        this.key = key;
    }

    public CarKey getKey() {
        return key;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SavedCar savedCar = (SavedCar) o;
        return Objects.equals(car, savedCar.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}
