package racingcar.view.input.validator;

public class CarNameInputValidator implements NotEmptyCheckable {
    public void validate(String userInput) {
        validateIsNotEmpty(userInput);
    }
}