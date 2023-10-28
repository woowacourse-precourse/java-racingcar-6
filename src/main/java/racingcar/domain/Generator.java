package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    public int generateRandomNum() {
        return Randoms.pickNumberInRange(1,9);
    }
}
