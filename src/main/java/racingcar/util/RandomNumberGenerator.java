package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Game;

public class RandomNumberGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(Game.MIN_RANDOM_NUMBER.is(), Game.MAX_RANDOM_NUMBER.is());
    }
}
