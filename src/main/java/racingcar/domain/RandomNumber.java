package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private int number;
    public int getNumber(){
        this.number = Randoms.pickNumberInRange(0,9);
        return number;
    }
}
