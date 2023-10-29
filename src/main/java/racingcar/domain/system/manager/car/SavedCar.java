package racingcar.domain.system.manager.car;

import java.util.Objects;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;

public class SavedCar {

    private final Car car;

    public SavedCar(Car car) {
        this.car = car;
    }

    public CarName getKey() {
        return car.getCarName();
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
