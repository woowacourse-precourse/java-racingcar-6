package racingcar.domain.system.manager.car.key;

import racingcar.domain.core.car.CarName;

public class CarKey implements Comparable<CarKey> {

    private final CarName key;

    public CarKey(CarName key) {
        this.key = key;
    }

    public static CarKey of(CarName key) {
        return new CarKey(key);
    }

    public static CarKey of(CarName carName, Long idx) {
        return new CarKey(new InputOrderCarName(carName, idx));
    }

    public CarName getKey() {
        return key;
    }

    @Override
    public int compareTo(CarKey o) {
        return key.getName().compareTo(o.key.getName());
    }
}
