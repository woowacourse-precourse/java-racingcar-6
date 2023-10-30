package racingcar.model;

public class RacingCar {
    private static final String PROGRESS_BAR = "-";
    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
    }

    public void moveForward(int distance) {
        this.distance += distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    public String getDistanceAsBar() {
        return PROGRESS_BAR.repeat(this.distance);
    }
}
