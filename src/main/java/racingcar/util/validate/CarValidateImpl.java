package racingcar.util.validate;
import racingcar.exception.CustomException;

public final class CarValidateImpl implements CarValidate {
    private CarValidateImpl(String input) {
        blankValidator(input);
        nullValidator(input);
        MaxLengthValidator(input);
    }

    public static void createValue(String input) {
        new CarValidateImpl(input);
    }

    @Override
    public void blankValidator(String input) {
        CustomException.blankValidator(input);
    }

    @Override
    public void nullValidator(String input) {
        CustomException.nullValidator(input);
    }

    @Override
    public void MaxLengthValidator(String input) {
        CustomException.MaxLengthValidator(input);
    }
}
