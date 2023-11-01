package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomSpeedGenerator implements CarSpeedGenerator {

    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_SPEED, MAX_SPEED);
    }
}
