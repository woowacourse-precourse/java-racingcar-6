package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int generateNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        return num;
    }
}
