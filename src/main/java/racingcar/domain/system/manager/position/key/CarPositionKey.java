package racingcar.domain.system.manager.position.key;

import java.util.Objects;

public class CarPositionKey implements Comparable<CarPositionKey> {

    private final Long key;

    public CarPositionKey(Long key) {
        this.key = key;
    }

    public static CarPositionKey of(Long key) {
        return new CarPositionKey(key);
    }

    public Long getKey() {
        return key;
    }

    @Override
    public int compareTo(CarPositionKey o) {
        return key.compareTo(o.key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPositionKey that = (CarPositionKey) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
