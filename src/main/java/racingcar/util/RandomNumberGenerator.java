package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.RacingGameConfig;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public int generate(){
        return Randoms.pickNumberInRange(RacingGameConfig.RANDOM_MIN_VALUE.getValue(), RacingGameConfig.RANDOM_MAX_VALUE.getValue());
    }
}
