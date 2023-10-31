package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Number {

    private Integer num;

    public Integer createOneDigitNumber(){

        this.num = Randoms.pickNumberInRange(0,9);
        return num;

    }
}
