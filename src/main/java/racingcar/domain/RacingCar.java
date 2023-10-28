package racingcar.domain;

public class RacingCar {
    private final String name;
    private Long distance;

    RacingCar(String name) {
        this.name = name;
        this.distance = 0L;
    }

    public String getName() {
        return name;
    }

    public Long getDistance() {
        return distance;
    }

    void move() {
        this.distance += 1;
    }
}
