package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateBetween(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
