package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator{

    public static int createRandomNumber(){
        return pickNumberInRange(0, 9);
    }

}
