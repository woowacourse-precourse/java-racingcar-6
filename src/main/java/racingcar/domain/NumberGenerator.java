package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int createRandomNumber(){
        int randomNum = Randoms.pickNumberInRange(1,9);
        return randomNum;
    }
}
