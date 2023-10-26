package racingcar.service;

import racingcar.util.RandomNumberGenerator;

public class Accelerator {

    public static boolean canMoveForward() {
        return RandomNumberGenerator.generate() >= 4;
    }
}
