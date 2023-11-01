package racingcar.model;

import racingcar.util.generator.NumberGenerator;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 4;
    private final NumberGenerator numberGenerator;
    private final CarName name;
    private final CarPosition position;

    public Car(final String name, final NumberGenerator numberGenerator) {
        this.name = new CarName(name);
        this.position = new CarPosition(0);
        this.numberGenerator = numberGenerator;
    }

    public void moveForward() {
        final int randomNumber = numberGenerator.generate();
        if (isMoveForward(randomNumber)) {
            position.increase();
        }
    }

    private boolean isMoveForward(final int randomNumber) {
        return randomNumber >= MOVEMENT_THRESHOLD;
    }

    public boolean isWinner(final int winnerPosition) {
        return position.getPosition() == winnerPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
