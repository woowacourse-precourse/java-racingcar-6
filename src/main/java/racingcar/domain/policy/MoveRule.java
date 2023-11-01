package racingcar.domain.policy;

public interface MoveRule {
    int generateValue(int minRange, int maxRange);
}