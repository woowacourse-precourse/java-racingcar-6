package racingcar.exception.cars;

public class DuplicateException extends IllegalArgumentException{
    public DuplicateException() {
        super("중복된 자동차 이름이 있습니다.");
    }
}
