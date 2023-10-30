package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    private final int startInclusive = 1;
    private final int endInclusive = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
