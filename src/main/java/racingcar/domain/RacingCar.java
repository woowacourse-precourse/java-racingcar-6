package racingcar.domain;

public class RacingCar {

    private final String name;
    private Integer forwardDistance = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void forward() {
        this.forwardDistance++;
    }

    public Integer getForwardDistance() {
        return forwardDistance;
    }
}
