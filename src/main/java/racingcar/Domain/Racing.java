package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    public int carSpeed() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
