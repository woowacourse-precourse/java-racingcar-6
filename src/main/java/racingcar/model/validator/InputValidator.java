package racingcar.model.validator;

public interface InputValidator {

    String validate(String input);

    Object getValidatedInput();
}
