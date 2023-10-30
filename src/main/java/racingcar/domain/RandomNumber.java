package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public int randomNumber(){
        int random = Randoms.pickNumberInRange(0,9);
        return random;
    }
}
