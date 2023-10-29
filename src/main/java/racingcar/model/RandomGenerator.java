package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public int createNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
