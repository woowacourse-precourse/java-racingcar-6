package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.option.GameOption;

public class RandomNumber {
    public static int create() {
        return Randoms.pickNumberInRange(GameOption.MINIMUM_NUMBER, GameOption.MAXIMUM_NUMBER);
    }
}
