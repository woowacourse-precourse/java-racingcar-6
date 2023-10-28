package racingcar.domain;

import racingcar.generator.RandomGenerator;

public class GameCondition {

    public static boolean hasDriveCondition() {
        return RandomGenerator.generteRandomInteger() >= 4;
    }
}
