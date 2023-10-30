package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomReferee implements Referee {
    private static final int MIN_DICE_VALUE = 0;
    private static final int MAX_DICE_VALUE = 9;
    private static final int STANDARD_VALUE = 4;

    @Override
    public boolean shouldMove() {
        int value = Randoms.pickNumberInRange(MIN_DICE_VALUE, MAX_DICE_VALUE);

        return value >= STANDARD_VALUE;
    }
}
