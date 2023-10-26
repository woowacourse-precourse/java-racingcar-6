package racingcar;

public class RaceCar {

    private final CarName name;
    private final RacePosition position;

    public RaceCar(CarName name) {
        this.name = name;
        this.position = new RacePosition();
    }

    public void moveForward() {
        position.moveForward();
    }

    public int compareTo(RaceCar other) {
        return position.compareTo(other.position);
    }
}
