package racingcar.policy;

@FunctionalInterface
public interface MovingPolicy {

    boolean canMove(int number);

}