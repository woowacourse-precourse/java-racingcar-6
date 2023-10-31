package racingcar.domain;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return name;
    }
}
