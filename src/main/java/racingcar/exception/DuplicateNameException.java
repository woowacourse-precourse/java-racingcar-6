package racingcar.exception;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException() {
        super("중복된 이름이 존재합니다.");
    }
}
