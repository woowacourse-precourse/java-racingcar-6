package racingcar.domain.system.manager.position.key;

import racingcar.domain.core.car.CarName;

public class CarPositionKey implements Comparable<CarPositionKey> {

    private final String key;

    public CarPositionKey(CarName key) {
        this.key = key.getName() + "_position";
    }

    public static CarPositionKey of(CarName key) {
        return new CarPositionKey(key);
    }

    public String getKey() {
        return key;
    }

    @Override
    public int compareTo(CarPositionKey o) {
        return key.compareTo(o.key);
    }
}
