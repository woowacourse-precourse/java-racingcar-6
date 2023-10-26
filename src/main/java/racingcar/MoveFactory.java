package racingcar;

public class MoveFactory {

    private final NumberGenerator numberGenerator;

    public MoveFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMove() {
        if (isOverFour(numberGenerator)) {
            return true;
        }
        return false;
    }

    private boolean isOverFour(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= 4;
    }
}
