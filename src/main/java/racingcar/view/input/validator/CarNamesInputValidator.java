package racingcar.view.input.validator;

public class CarNamesInputValidator implements NotEmptyCheckable, ContainingDelimiterCheckable {
    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateContainsDelimiter(userInput);
        validateIsNotEndWithDelimiter(userInput);
    }
}