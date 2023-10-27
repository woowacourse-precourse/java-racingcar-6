package racingcar.exception;

public class CarRepositoryException extends IllegalArgumentException {

    public static final String DUPLICATE = "같은 이름을 가진 자동차가 존재합니다.";
    public static final String NOT_FOUND = "자동차가 존재하지 않습니다.";

    public CarRepositoryException(String s) {
        super(s);
    }

}
