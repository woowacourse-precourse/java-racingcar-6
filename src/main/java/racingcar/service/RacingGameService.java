package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGameService {
    public boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
