package racingcar.model.validator.carName;

public interface CarNameValidator {
    void validateSyntax(String[] inputs);
    void validateLength(String[] inputs);
    void validateDuplicate(String[] inputs);
    void validateAll(String[] carNamesFromUsers);
}
