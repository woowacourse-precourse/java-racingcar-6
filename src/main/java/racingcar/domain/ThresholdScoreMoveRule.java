package racingcar.domain;

public final class ThresholdScoreMoveRule implements MoveRule {
    private final NumberGenerator numberGenerator;

    public ThresholdScoreMoveRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private static final int MIN_MOVE_NUMBER = 4;
    private static final int FORWARD = 1;
    private static final int STOP = 0;

    @Override
    public int tryMove(NumberGenerator generator) {
        int number = numberGenerator.generate();
        if (number >= MIN_MOVE_NUMBER) {
            return FORWARD;
        }
        return STOP;
    }
}
