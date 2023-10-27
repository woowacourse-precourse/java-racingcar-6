package racingcar.domain;

public class LimitScoreRacingRule implements RacingRule {
    private final NumberGenerator numberGenerator;

    public LimitScoreRacingRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MOVE_SUCCESS_LENGTH = 1;
    private static final int MOVE_FAIL = 0;

    @Override
    public int tryMove() {
        int number = numberGenerator.generate();
        if (number >= MIN_MOVE_NUMBER) {
            return MOVE_SUCCESS_LENGTH;
        }
        return MOVE_FAIL;
    }
}
