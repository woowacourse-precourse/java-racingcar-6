package racingcar.domain.game;

import static racingcar.constant.GameConstant.END_OF_RANDOM_GENERATOR_RANGE;
import static racingcar.constant.GameConstant.MOVING_FORWARD_THRESHOLD;
import static racingcar.constant.GameConstant.START_OF_RANDOM_GENERATOR_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class GameCondition {

    public static boolean hasDriveCondition() {
        return Randoms.pickNumberInRange(START_OF_RANDOM_GENERATOR_RANGE, END_OF_RANDOM_GENERATOR_RANGE)
                >= MOVING_FORWARD_THRESHOLD;
    }
}
