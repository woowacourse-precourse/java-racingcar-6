package racingcar.model;

import racingcar.NumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public int createNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
