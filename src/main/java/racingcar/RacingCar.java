package racingcar;

public class RacingCar {
    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void incrementDistance() {
        this.distance += 1;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
