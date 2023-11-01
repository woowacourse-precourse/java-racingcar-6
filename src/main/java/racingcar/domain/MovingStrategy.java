package racingcar.domain;

@FunctionalInterface
public interface MovingStrategy {
    boolean canMove();
}
