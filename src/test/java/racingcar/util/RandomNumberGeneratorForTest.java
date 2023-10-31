package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorForTest implements NumberGenerator{

    private final int START_INCLUSIVE = 4;
    private final int END_INCLUSIVE = 9;
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE);
    }
}
