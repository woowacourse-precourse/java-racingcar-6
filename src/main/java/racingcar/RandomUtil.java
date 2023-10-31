package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int getRandomNumber() {

        return Randoms.pickNumberInRange(GameConfig.MIN_RANDOM_NUMBER.getValue(), GameConfig.MAX_RANDOM_NUMBER.getValue());
    }
}
