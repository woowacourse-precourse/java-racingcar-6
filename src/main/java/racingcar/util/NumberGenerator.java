package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {


    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
