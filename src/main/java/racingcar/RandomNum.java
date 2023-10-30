package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomNum {

    final int START_NUMBER = 1;
    final int LAST_NUMBER = 9;
    public int number(){return Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);}
}
