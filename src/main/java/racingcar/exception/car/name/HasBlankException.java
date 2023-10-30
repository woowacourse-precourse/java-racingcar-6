package racingcar.exception.car.name;

public class HasBlankException extends IllegalArgumentException {
    public static final String HasBlankExceptionMessage = "공백이 포함되어 있습니다.";

    public HasBlankException() {
        super(HasBlankExceptionMessage);
    }
}
