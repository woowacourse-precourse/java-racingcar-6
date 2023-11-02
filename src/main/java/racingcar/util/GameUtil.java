package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.RoundValidator;

public class GameUtil {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public static int setRepeatCount(String round) {
        RoundValidator roundValidator = new RoundValidator(round);
        return Integer.parseInt(roundValidator.repeatNum);
    }
}
