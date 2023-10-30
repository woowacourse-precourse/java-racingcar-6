package racingcar.service;

import racingcar.constant.Rule;
import racingcar.util.RandomNumberGenerator;

public class Accelerator {

    public boolean canMoveForward() {
        return RandomNumberGenerator.generate() >= Rule.MOVEMENT_POSSIBILITY;
    }
}
