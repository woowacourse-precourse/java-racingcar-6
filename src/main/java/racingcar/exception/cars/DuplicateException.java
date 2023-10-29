package racingcar.exception.cars;

public class DuplicateException extends IllegalArgumentException{
    public static final String DuplicateExceptionMessage = "중복된 자동차 이름이 있습니다.";
    public DuplicateException() {
        super(DuplicateExceptionMessage);
    }
}
