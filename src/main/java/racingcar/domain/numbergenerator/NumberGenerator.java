package racingcar.domain.numbergenerator;

@FunctionalInterface
public interface NumberGenerator {
    default MoveNumber generate() {
        return new MoveNumber(pickNumber());
    }

    int pickNumber();
}
