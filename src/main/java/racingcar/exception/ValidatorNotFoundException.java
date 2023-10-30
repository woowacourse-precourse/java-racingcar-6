package racingcar.exception;

public class ValidatorNotFoundException extends IllegalArgumentException {
    public static final String ValidatorNotFoundExceptionMessage = "해당 객체를 검증하기 위한 Validator가 존재하지 않습니다.";
    public ValidatorNotFoundException() {
        super(ValidatorNotFoundExceptionMessage);
    }
}
