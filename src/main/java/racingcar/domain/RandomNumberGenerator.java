package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Constants;
public class RandomNumberGenerator {
    public int generateRandomNumber(){
        int randomNumber  = Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
        return randomNumber;
    }
}

