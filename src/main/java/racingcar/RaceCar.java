package racingcar;

import racingcar.view.Output;

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

    public void printCurrentPositions() {
        Output.printMessage(name + " : " + position.drawProcess());
    }

    @Override
    public String toString() {
        return name.name();
    }
}
