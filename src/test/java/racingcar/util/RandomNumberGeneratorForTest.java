package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorForTest implements NumberGenerator{

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(4,9);
    }
}
