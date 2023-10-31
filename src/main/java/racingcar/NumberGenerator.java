package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
