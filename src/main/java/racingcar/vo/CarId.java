package racingcar.vo;

public final class CarId {

    private final long value;

    public CarId(final long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarId carId = (CarId) o;
        return value == carId.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }
}
