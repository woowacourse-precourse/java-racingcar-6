package racingcar.controller.random;

import camp.nextstep.edu.missionutils.Randoms;

public class randomOneToNine implements RandomMove{
    private int getRandom() {
        return Randoms.pickNumberInRange(1, 9);
    }

    @Override
    public boolean getMove() {
        return getRandom() >= 4;
    }
}
