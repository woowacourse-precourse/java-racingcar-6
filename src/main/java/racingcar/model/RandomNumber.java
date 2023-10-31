package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private int randomNum;

    RandomNumber(){
    }

    public void make(){
        this.randomNum = pickNumberInRange(0,9);
    }
}
