package racingcar.domain.policy;

public class MovePolicy {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private static final int MOVE_THRESHOLD = 4;

    private MovePolicy() {
    }

    public static boolean canMove(DriveRule driveRule) {
        return driveRule.generateValue(MIN_RANGE, MAX_RANGE) >= MOVE_THRESHOLD;
    }
}