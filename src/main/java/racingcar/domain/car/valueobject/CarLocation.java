package racingcar.domain.car.valueobject;

public class CarLocation {
    private int location;

    public CarLocation() {
        this.location = 0;
    }

    public int getInteger() {
        return location;
    }

    public void forward() {
        location++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarLocation that = (CarLocation) o;

        return location == that.location;
    }

    @Override
    public int hashCode() {
        return location;
    }
}
