package racingcar.domain.game;

import racingcar.generator.RandomGenerator;

public class GameCondition {

    public static boolean hasDriveCondition() {
        return RandomGenerator.generteRandomInteger() >= 4;
    }
}
