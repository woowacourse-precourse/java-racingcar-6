package racingcar.domain;

import static racingcar.utils.Constants.MAX_STRENGTH;
import static racingcar.utils.Constants.MIN_STRENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.NumberGenerator;

public class Driver implements NumberGenerator {
    public int press() {
        int pressStrength = Randoms.pickNumberInRange(MIN_STRENGTH, MAX_STRENGTH);
        return pressStrength;
    }
}
