package racingcar.domain;

public class Judge {
    private static final int JUDGE_CAN_GO_NUMBER = 4;
    public boolean canRush(int canRushNumber) {
        return canRushNumber >= JUDGE_CAN_GO_NUMBER;
    }
}
