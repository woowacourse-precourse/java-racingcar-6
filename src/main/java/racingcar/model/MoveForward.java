package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveForward {

    public static Boolean success() {
        return 4 <= Randoms.pickNumberInRange(0, 10);
    }
}
