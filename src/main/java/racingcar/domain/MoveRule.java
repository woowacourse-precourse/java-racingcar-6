package racingcar.domain;

public interface MoveRule extends NumberGenerator {
    int tryMove(int number);
}
