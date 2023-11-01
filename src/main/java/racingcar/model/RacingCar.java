package racingcar.model;

public class RacingCar {
    private final String name;
    private int distance;

    public String getName() {
        return this.name;
    }

    public RacingCar(String carName, int distance) {
        this.name = carName;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void addDistance() {
        this.distance += 1;
    }
}
