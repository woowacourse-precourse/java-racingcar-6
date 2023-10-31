package racingcar.domain;

public class Computer {
    private final static int MOVEMENT_FLAG = 4;
    public boolean judgeCarMovement(int random) {
        if (random >= 4) {
            return true;
        }
        return false;
    }

    public void judgeWinner() {

    }
}
