package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.domain.Constants.*;
public class RandomNumberGenerator {
    public int generateRandomNumber(){
        int randomNumber  = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        return randomNumber;
    }
}

