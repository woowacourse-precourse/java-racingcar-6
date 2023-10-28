package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private final String name;
    private Integer forwardDistance = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void forward() {
        this.forwardDistance++;
    }

    public String getName() {
        return name;
    }

    public Integer getForwardDistance() {
        return forwardDistance;
    }


    @Override
    public int compareTo(RacingCar other) {
        return Integer.compare(this.forwardDistance, other.forwardDistance);
    }
}
