package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator{

    public int createRandomNumber(){
        return pickNumberInRange(0, 9);
    }

}
