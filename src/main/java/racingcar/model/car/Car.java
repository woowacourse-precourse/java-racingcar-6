package racingcar.model.car;

import racingcar.constant.RacingGameConstants;
import racingcar.utils.RandomGenerator;

public class Car {
    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        position = 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void TryToMove() {
        int randomNumber = RandomGenerator
                .generateRandomIntInRange(RacingGameConstants.MOVE_ENERGY_MIN, RacingGameConstants.MOVE_ENERGY_MAX);

        if(randomNumber >= RacingGameConstants.ENERGY_THRESHOLD_TO_MOVE) {
            moveOneStep();
        }
    }

    public void moveOneStep() {
        position++;
    }
}
