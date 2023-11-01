package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int carCount;


    public boolean isForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }


}
