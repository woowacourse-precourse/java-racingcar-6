package racingcar.service.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class WootecoEngine implements Engine {
    private int startInclusive = 0;
    private int endInclusive = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
