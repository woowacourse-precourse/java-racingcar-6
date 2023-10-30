package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.consts.GameConstant;

public class RandomGenerator {
    public int generate() {
        return pickNumberInRange(GameConstant.MIN_NUMBER_RANDOM_RANGE.get(),
                GameConstant.MAX_NUMBER_RANDOM_RANGE.get());
    }
}
