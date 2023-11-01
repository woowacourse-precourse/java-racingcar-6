package racingcar.domain;

public class Move {
    private static final int ADVANCE_NUMBER = 4;

    public static boolean isMove(int randomNumber) {
        return randomNumber >= ADVANCE_NUMBER;
    }
}
