package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public enum MoveOrder {MOVE_FORWARD, STOP}

    public static MoveOrder getMoveOrder() {
        int number = getRandomNumber();
        if (isMoveForward(number)) {
            return MoveOrder.MOVE_FORWARD;
        }
        return MoveOrder.STOP;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static boolean isMoveForward(int number) {
        return number >= 4;
    }
}
