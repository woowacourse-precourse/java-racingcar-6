package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkMoreThanFour(int randomNumber) {
        if(randomNumber >= 4 ) {
            return true;
        } else {
            return false;
        }
    }
}
