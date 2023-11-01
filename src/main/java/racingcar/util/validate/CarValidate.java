package racingcar.util.validate;

public sealed interface CarValidate permits CarValidateImpl {
    void blankValidator(String input);
    void nullValidator(String input);
    void MaxLengthValidator(String input);
}
