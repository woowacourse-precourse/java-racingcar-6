package game;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomGenerator implements RandomGenerator {

    @Override
    public int pickNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
