package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Selector {
    public String whetherToGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return "전진";
        }
        else {
            return "정지";
        }
    }
}
