package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomStrategy implements Strategy{

    private int MIN_VALUE = 0;
    private int MAX_VALUE = 9;
    private int MIN_NUMBER = 4;

    @Override
    public boolean movable() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE) >= MIN_NUMBER;
    }
}
