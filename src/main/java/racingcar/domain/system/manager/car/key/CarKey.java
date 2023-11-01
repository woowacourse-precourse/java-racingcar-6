package racingcar.domain.system.manager.car.key;

public class CarKey implements Comparable<CarKey> {

    private final Long key;

    public CarKey(Long key) {
        this.key = key;
    }

    public static CarKey of(Long key) {
        return new CarKey(key);
    }

    public Long getKey() {
        return key;
    }

    @Override
    public int compareTo(CarKey o) {
        return key.compareTo(o.key);
    }
}
