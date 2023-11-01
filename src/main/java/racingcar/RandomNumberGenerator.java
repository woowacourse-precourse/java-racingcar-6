package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.underhood.GameRule;

public class RandomNumberGenerator {

    public static int pickRandomNumber(GameRule rule) {
        return Randoms.pickNumberInRange(rule.getMinNumberInclude(), rule.getMaxNumberInclude());
    }
}
