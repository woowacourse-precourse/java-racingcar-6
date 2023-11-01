package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RaceCar {
    private static final int MOVE_THRESHOLD = 4;
    private final Name name;
    private Position position;

    public RaceCar(Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    public boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public void moveForward() {
        int randomValue = RandomNumberGenerator.generate();
        if (canMove(randomValue)) {
            position = position.increment();
        }
    }

    public String currentStatus() {
        return this.name + " : " + "-".repeat(Math.max(0, this.position.value()));
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
