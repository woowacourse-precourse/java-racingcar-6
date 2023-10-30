package racingcar.domain;

public class MovePossibilityChecker {
    private static final int MINIMUM_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public MovePossibilityChecker(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

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
