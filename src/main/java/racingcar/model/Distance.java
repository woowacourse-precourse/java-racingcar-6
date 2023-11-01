package racingcar.model;

import racingcar.enums.Constants;

import java.util.Objects;

public class Distance {
    private Integer distance;

    public Distance() {
        this.distance = Constants.INITIAL_DISTANCE.getNumber();
    }

    public Integer getDistance() {
        return distance;
    }

    public void updateDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance1 = (Distance) o;

        return Objects.equals(distance, distance1.distance);
    }

    @Override
    public int hashCode() {
        return distance != null ? distance.hashCode() : 0;
    }
}
