package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtils {
    private final static int MOVE_CONDITION_NUMBER = 4;
    private final static String MOVE = "-";
    private final static String NO_MOVE = "";

    public static String movingCar() {
        if(isMove(randomMoveNumber())) {
            return MOVE;
        }
        return NO_MOVE;
    }

    private static boolean isMove(int moveNumber) {
        return moveNumber >= MOVE_CONDITION_NUMBER ? true : false;
    }

    private static int randomMoveNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
