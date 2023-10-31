package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.RandomNumber;

public class NumberGenerator {
    public Integer createRandomSingleNumber() {
        Integer rangeMin = RandomNumber.MIN.getValue();
        Integer rangeMax = RandomNumber.MAX.getValue();

        return Randoms.pickNumberInRange(rangeMin, rangeMax);
    }
}
