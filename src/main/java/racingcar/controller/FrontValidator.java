package racingcar.controller;

public sealed interface FrontValidator permits InputValidator {
    void validateSingleNumber(String givenInput);
    void validateNamesByDelimiter(String givenInput, String delimiter);
}
