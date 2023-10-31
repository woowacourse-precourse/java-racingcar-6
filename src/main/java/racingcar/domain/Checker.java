package racingcar.domain;

import camp.nextstep.edu.missionutils.*;

public class Checker {
    public boolean advance() {
        int temp = Randoms.pickNumberInRange(0, 9);
        return temp >= 4;
    }
}
