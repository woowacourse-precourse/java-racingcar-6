package racingcar.service.random;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberProvider implements RandomNumberProvider{
    private final static int startInclusive = 0;
    private final static int endInclusive = 9;
    
    @Override
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
