package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    int movementNumber= Randoms.pickNumberInRange(0,9);

    public String decideAction() {
        if (movementNumber >= 4) {
            return "-";
        } return null;
    }
}
