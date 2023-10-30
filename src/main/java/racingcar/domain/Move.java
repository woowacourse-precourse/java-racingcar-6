package racingcar.domain;

public class Move {
    private static final int ADVANCE_NUMBER = 4;

    public static boolean isMove() {
        if (RandomNumber.generateNumber() >= ADVANCE_NUMBER) {
            return true;
        }
        return false;
    }
}
