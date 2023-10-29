package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private NumberGenerator(){
    }

    public static int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
