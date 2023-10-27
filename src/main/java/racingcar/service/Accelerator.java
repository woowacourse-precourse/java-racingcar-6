package racingcar.service;

import racingcar.constant.Rule;
import racingcar.util.RandomNumberGenerator;

public class Accelerator {

    private Accelerator() {
    }

    public static boolean canMoveForward() {
        return RandomNumberGenerator.generate() >= Rule.MOVING_POSSIBILITY;
    }
}
