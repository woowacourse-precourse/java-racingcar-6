package racingcar.race;

import racingcar.CarName;
import racingcar.util.MoveProbability;
import racingcar.util.RandomNumberGenerator;

public class RaceCar {

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
        MoveProbability probability = MoveProbability.getInstance(new RandomNumberGenerator());
        return probability.canMoveForward();
    }

    public int compareTo(RaceCar other) {
        return position.compareTo(other.position);
    }

    public String getCurrentPositions() {
        return position.drawProcess();
    }

    @Override
    public String toString() {
        return name.name();
    }
}
