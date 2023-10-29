package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandNum {

    public int createRandomNumber() {
        int randomnumber = Randoms.pickNumberInRange(0, 9);
        return randomnumber;
    }

}
