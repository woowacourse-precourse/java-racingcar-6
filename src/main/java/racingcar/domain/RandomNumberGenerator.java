package racingcar.domain;

import static racingcar.constant.RacingGameContant.MAX_VALUE;
import static racingcar.constant.RacingGameContant.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static Integer generate() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}
