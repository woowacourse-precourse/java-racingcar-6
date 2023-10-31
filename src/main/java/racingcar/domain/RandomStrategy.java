package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomStrategy implements Strategy{
    @Override
    public boolean movable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
