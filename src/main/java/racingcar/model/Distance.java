package racingcar.model;

public class Distance {
    private Integer distance;

    public Distance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
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
