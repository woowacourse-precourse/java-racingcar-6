package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveGenrator {
    public int generateRandomMove() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
