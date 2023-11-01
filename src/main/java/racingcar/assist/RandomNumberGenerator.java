package racingcar.assist;

import static racingcar.system.SystemConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static int generateRandomIntNumberInRange(){
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE);
    }
}
