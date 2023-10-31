package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class OneDigitRandomNumber {

    private Integer num;

    public OneDigitRandomNumber(){
        this.num = Randoms.pickNumberInRange(0,9);
    }
}
