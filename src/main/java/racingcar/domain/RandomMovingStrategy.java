package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    @Override
    public int generateValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
