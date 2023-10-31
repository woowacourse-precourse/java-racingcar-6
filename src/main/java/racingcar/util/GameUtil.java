package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameInfo;

public class GameUtil {

    public static boolean getMoveOrStop() {
        return getRandomNumber() >= GameInfo.MOVE_OR_STOP_CRITERIA;
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(GameInfo.MIN_RANDOM_NUM, GameInfo.MAX_RANDOM_NUM);
    }
}
