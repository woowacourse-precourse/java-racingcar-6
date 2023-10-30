package racingcar.model.validator.carName;

public interface CarNameValidator {
    void validateCount(String[] inputs);
    void validateLength(String[] inputs);
    void validateDuplicate(String[] inputs);
}
