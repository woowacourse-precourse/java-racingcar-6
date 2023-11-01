package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GetRandomNumber {
    public boolean getTrueOrFalse() {
        boolean tOrF;
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum > 3) tOrF = true;
        else tOrF = false;
        return tOrF;
    }
}

