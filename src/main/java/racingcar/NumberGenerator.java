package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int randomNumber = createRandomNumber();
    public int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
