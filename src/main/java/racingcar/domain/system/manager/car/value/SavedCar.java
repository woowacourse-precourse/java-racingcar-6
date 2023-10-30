package racingcar.domain.system.manager.car.value;

import java.util.Objects;
import racingcar.domain.core.car.BasicCar;
import racingcar.domain.core.car.CarName;
import racingcar.domain.system.manager.car.key.CarKey;

public class SavedCar {

    private final BasicCar car;
    private final CarKey key;

    public SavedCar(BasicCar car, CarKey key) {
        this.car = car;
        this.key = key;
    }

    public CarKey getKey() {
        return key;
    }

    public BasicCar getCar() {
        return car;
    }

    public CarName getCarName() {
        return car.getCarName();
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
