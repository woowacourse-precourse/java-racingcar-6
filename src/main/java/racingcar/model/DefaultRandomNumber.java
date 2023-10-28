package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumber implements RandomNumberProvider{
    private final static int startInclusive = 0;
    private final static int endInclusive = 9;
    
    @Override
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
