package racingcar.domain.entity.valueobject;

import racingcar.domain.config.GameConfig;

public class CarLocation {
    private static final int START_LOCATION = GameConfig.START_LOCATION;
    private int location;

    public CarLocation() {
        this.location = START_LOCATION;
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
