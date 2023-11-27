package racingcar.view.input.validator;

public class TrialTimesValidator implements NotEmptyCheckable, PositiveNumericCheckable {
    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
        validateIsNumeric(userInput);
        validateIsPositive(userInput);
    }
}