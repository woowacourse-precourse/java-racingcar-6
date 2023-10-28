package racingcar.actionnumber;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomActionNumberGenerator implements ActionNumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
