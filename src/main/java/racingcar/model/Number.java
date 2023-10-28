package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
