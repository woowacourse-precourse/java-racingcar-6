package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameOption;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Integer createNumber() {
        return Randoms.pickNumberInRange(GameOption.RANDOM_NUMBER_MIN, GameOption.RANDOM_NUMBER_MAX);
    }
}
