package racingcar.vo;

import camp.nextstep.edu.missionutils.Randoms;

public class OneDigitRandomNumber {

    private Integer num;

    public OneDigitRandomNumber(){

        this.num = Randoms.pickNumberInRange(0,9);

    }

    public boolean judgmentFourOrMore(){

        if (this.num >= 4){

            return true;

        }

        return false;
    }
}
