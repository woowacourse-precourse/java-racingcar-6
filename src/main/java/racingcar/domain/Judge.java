package racingcar.domain;

public class Judge {
    private static final int JUDGE_CAN_GO_NUMBER = 4;

    public static boolean canRush() {
        return RandomNumberGenerator.createRandomNumber() >= JUDGE_CAN_GO_NUMBER;
    }
}
