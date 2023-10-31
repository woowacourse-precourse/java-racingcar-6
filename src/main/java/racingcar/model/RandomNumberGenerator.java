package racingcar.model;

import static racingcar.constant.GameConstant.RANDOM_MAX_NUM;
import static racingcar.constant.GameConstant.RANDOM_MIN_NUM;
import static racingcar.constant.GameConstant.SCORE_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static boolean isRacingCarProceed() {
        return getRandomNumberInRange() >= SCORE_BOUND.getValue();
    }

    private static int getRandomNumberInRange() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUM.getValue(), RANDOM_MAX_NUM.getValue());
    }
}
