package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RanNumService {

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
