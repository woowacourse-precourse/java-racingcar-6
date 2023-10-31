package racingcar.domain;

public class AutoMoveChecker implements MoveChecker {
    private static final int MINIMUM_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public AutoMoveChecker(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public MoveInstruction canMove() {
        if (numberIsMoreThanThree()) {
            return MoveInstruction.FORWARD;
        }
        return MoveInstruction.STAY;
    }

    private boolean numberIsMoreThanThree() {
        return randomNumberGenerator.generateRandomNumber() >= MINIMUM_NUMBER;
    }
}
