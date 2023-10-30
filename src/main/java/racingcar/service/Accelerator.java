package racingcar.service;

import racingcar.constant.Rule;
import racingcar.util.RandomNumberGenerator;

public class Accelerator {

    public boolean canMoveForward() {
        return Rule.MOVEMENT_POSSIBILITY <= getMovementPotential();
    }

    private Integer getMovementPotential() {
        return RandomNumberGenerator.generate();
    }
}
