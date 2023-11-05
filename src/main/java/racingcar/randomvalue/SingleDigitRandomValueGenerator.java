package racingcar.randomvalue;

import camp.nextstep.edu.missionutils.Randoms;

public class SingleDigitRandomValueGenerator implements RandomValueGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
