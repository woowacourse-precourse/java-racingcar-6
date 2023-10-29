package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    private int min;
    private int max;

    public Dice(int min, int max){
        this.min = min;
        this.max = max;
    }

    protected int roll(){
        return Randoms.pickNumberInRange(min, max);
    }

}
