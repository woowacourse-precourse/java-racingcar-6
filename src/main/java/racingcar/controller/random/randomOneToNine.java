package racingcar.controller.random;

import camp.nextstep.edu.missionutils.Randoms;

public class randomOneToNine implements RandomMove{
    @Override
    public int getRandom() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
