package racingcar.domain;

public class MoveProbability {

    private static final int THRESHOLD = 4;

    private final int number;

    private MoveProbability(NumberGenerator numberGenerator) {
        number = numberGenerator.generate();
    }

    public static MoveProbability getInstance(NumberGenerator numberGenerator) {
        return new MoveProbability(numberGenerator);
    }

    public boolean canMoveForward() {
        return number >= THRESHOLD;
    }
}
