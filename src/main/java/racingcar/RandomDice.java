package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDice {
    private int num;

    void setNum(){
        this.num = Randoms.pickNumberInRange(0,9);
    }

    int getNum(){
        return this.num;
    }
}
