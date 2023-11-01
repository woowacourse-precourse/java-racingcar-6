package racingcar.validateName;

public class ValidateNameImpl implements ValidateName {
    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
