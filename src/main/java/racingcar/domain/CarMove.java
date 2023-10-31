package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMove {
    public static boolean moveOrNot() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }
}
