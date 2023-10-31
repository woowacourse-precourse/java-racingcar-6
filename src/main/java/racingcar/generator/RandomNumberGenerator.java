package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generateNumberRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
