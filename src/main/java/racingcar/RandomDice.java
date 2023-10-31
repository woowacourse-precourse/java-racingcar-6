package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDice {
    static int getNum(){
        return Randoms.pickNumberInRange(0,9);
    }
}
