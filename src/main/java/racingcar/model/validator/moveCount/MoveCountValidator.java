package racingcar.model.validator.moveCount;

public interface MoveCountValidator {
    void validateType(Long input);

    void validatePositive(Long input);

    void validateAll(Long input);
}
