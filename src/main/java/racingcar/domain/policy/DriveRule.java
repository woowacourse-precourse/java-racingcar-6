package racingcar.domain.policy;

public interface DriveRule {
    int generateValue(int minRange, int maxRange);
}