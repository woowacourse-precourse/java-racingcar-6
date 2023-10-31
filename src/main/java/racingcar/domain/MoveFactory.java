package racingcar.domain;

public class MoveFactory {

    private final NumberGenerator numberGenerator;

    public MoveFactory(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMove() {
        if (isOverFour(numberGenerator)) {
            return true;
        }
        return false;
    }

    private boolean isOverFour(final NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= 4;
    }
}
