package racingcar.model.rule;

public sealed interface GameRule permits GameRuleValidator, RandomNumberGenerator , CarMovementStatus {
    int MIN_NAME_LENGTH = 1;
    int MAX_NAME_LENGTH = 5;
    int MIN_RANGE_VALUE = 0;
    int MAX_RANGE_VALUE = 9;
    int MOVING_MIN_CONDITION_VALUE = 3;
}
