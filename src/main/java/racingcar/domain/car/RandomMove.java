package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMove implements RandomUtil{

    @Override
    public boolean moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }
}
