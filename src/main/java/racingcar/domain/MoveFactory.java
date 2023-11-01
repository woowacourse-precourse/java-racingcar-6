package racingcar.domain;

public class MoveFactory {

    private final NumberGenerator numberGenerator;

    public MoveFactory(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMove() {
        int randomNumber = numberGenerator.generate();
        if (isOverOrFour(randomNumber)) {
            return true;
        }
        return false;
    }

    private boolean isOverOrFour(final int randomNumber) {
        return randomNumber >= 4;
    }
}
