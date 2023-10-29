package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CheckMoveAndStop {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public static boolean isMove(){
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

        return randomNumber >= 4;
    }
}
