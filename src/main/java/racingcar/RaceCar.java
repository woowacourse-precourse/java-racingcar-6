package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.domain.MoveProbability;
import racingcar.view.Output;

public class RaceCar {

    private static final String FIELD_SEPARATOR = " : ";

    private final CarName name;
    private final RacePosition position;

    public RaceCar(CarName name) {
        this.name = name;
        this.position = new RacePosition();
    }

    public void moveForward() {
        if (canMoveForward()) {
            position.moveForward();
        }
    }

    private boolean canMoveForward() {
        MoveProbability probability = MoveProbability.getInstance(AppConfig.getNumberGenerator());
        return probability.canMoveForward();
    }

    public int compareTo(RaceCar other) {
        return position.compareTo(other.position);
    }

    public void printCurrentPositions() {
        Output.printMessage(name + FIELD_SEPARATOR + position.drawProcess());
    }

    @Override
    public String toString() {
        return name.name();
    }
}
