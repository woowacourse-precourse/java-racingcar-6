package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int generateRandomNumber(){
        int randomNumber  = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}

